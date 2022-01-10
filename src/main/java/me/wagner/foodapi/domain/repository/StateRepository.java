package me.wagner.foodapi.domain.repository;

import me.wagner.foodapi.domain.model.State;

import java.util.List;

public interface StateRepository {

    List<State> list();

    State findById(Long id);

    State add(State state);

    void remove(State state);
}
