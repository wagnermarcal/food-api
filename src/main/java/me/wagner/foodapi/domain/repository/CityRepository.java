package me.wagner.foodapi.domain.repository;

import me.wagner.foodapi.domain.model.City;

import java.util.List;

public interface CityRepository {

    List<City> list();

    City findById(Long id);

    City add(City city);

    void remove(City city);
}
