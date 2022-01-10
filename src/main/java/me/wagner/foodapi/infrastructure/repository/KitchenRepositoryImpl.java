package me.wagner.foodapi.infrastructure.repository;

import me.wagner.foodapi.domain.model.Kitchen;
import me.wagner.foodapi.domain.repository.KitchenRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class KitchenRepositoryImpl implements KitchenRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Kitchen> list() {
        return manager.createQuery("from Kitchen", Kitchen.class).getResultList();
    }

    @Override
    public Kitchen findById(Long id) {
        return manager.find(Kitchen.class, id);
    }

    @Transactional
    @Override
    public Kitchen add(Kitchen kitchen) {
        return manager.merge(kitchen);
    }

    @Transactional
    @Override
    public void remove(Kitchen kitchen) {
        kitchen = findById(kitchen.getId());
        manager.remove(kitchen);
    }
}
