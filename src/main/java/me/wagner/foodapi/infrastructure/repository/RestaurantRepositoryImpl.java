package me.wagner.foodapi.infrastructure.repository;

import me.wagner.foodapi.domain.model.Restaurant;
import me.wagner.foodapi.domain.repository.RestaurantRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurant> list() {
        return manager.createQuery("from Restaurant", Restaurant.class).getResultList();
    }

    @Override
    public Restaurant findById(Long id) {
        return manager.find(Restaurant.class, id);
    }

    @Transactional
    @Override
    public Restaurant add(Restaurant restaurant) {
        return manager.merge(restaurant);
    }

    @Transactional
    @Override
    public void remove(Restaurant restaurant) {
        restaurant = findById(restaurant.getId());
        manager.remove(restaurant);
    }
}
