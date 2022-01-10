package me.wagner.foodapi.domain.repository;

import me.wagner.foodapi.domain.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodRepository {

    List<PaymentMethod> list();

    PaymentMethod findById(Long id);

    PaymentMethod add(PaymentMethod paymentMethod);

    void remove(PaymentMethod paymentMethod);
}
