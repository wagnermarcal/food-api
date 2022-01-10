package me.wagner.foodapi.domain.repository;

import me.wagner.foodapi.domain.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    List<Restaurant> list();

    Restaurant findById(Long id);

    Restaurant add(Restaurant restaurant);

    void remove(Restaurant restaurant);
}
