package me.wagner.foodapi.domain.repository;

import me.wagner.foodapi.domain.model.Permission;

import java.util.List;

public interface PermissionRepository {

    List<Permission> list();

    Permission findById(Long id);

    Permission add(Permission permission);

    void remove(Permission permission);
}
