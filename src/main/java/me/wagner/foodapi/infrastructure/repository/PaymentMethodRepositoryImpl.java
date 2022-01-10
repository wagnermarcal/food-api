package me.wagner.foodapi.infrastructure.repository;

import me.wagner.foodapi.domain.model.PaymentMethod;
import me.wagner.foodapi.domain.model.Restaurant;
import me.wagner.foodapi.domain.repository.PaymentMethodRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<PaymentMethod> list() {
        return manager.createQuery("from PaymentMethod", PaymentMethod.class).getResultList();
    }

    @Override
    public PaymentMethod findById(Long id) {
        return manager.find(PaymentMethod.class, id);
    }

    @Transactional
    @Override
    public PaymentMethod add(PaymentMethod paymentMethod) {
        return manager.merge(paymentMethod);
    }

    @Transactional
    @Override
    public void remove(PaymentMethod paymentMethod) {
        paymentMethod = findById(paymentMethod.getId());
        manager.remove(paymentMethod);
    }
}
