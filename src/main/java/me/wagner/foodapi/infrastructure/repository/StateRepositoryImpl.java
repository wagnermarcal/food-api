package me.wagner.foodapi.infrastructure.repository;

import me.wagner.foodapi.domain.model.State;
import me.wagner.foodapi.domain.repository.StateRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class StateRepositoryImpl implements StateRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<State> list() {
        return manager.createQuery("from State", State.class).getResultList();
    }

    @Override
    public State findById(Long id) {
        return manager.find(State.class, id);
    }

    @Transactional
    @Override
    public State add(State state) {
        return manager.merge(state);
    }

    @Transactional
    @Override
    public void remove(State state) {
        state = findById(state.getId());
        manager.remove(state);
    }
}
