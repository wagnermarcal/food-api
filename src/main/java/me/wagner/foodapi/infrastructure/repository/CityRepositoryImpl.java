package me.wagner.foodapi.infrastructure.repository;

import me.wagner.foodapi.domain.model.City;
import me.wagner.foodapi.domain.repository.CityRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CityRepositoryImpl implements CityRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<City> list() {
        return manager.createQuery("from City", City.class).getResultList();
    }

    @Override
    public City findById(Long id) {
        return manager.find(City.class, id);
    }

    @Transactional
    @Override
    public City add(City city) {
        return manager.merge(city);
    }

    @Transactional
    @Override
    public void remove(City city) {
        city = findById(city.getId());
        manager.remove(city);
    }
}
