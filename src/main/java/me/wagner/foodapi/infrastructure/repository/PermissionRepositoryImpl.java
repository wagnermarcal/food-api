package me.wagner.foodapi.infrastructure.repository;

import me.wagner.foodapi.domain.model.Permission;
import me.wagner.foodapi.domain.repository.PermissionRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class PermissionRepositoryImpl implements PermissionRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Permission> list() {
        return manager.createQuery("from Permission", Permission.class).getResultList();
    }

    @Override
    public Permission findById(Long id) {
        return manager.find(Permission.class, id);
    }

    @Transactional
    @Override
    public Permission add(Permission permission) {
        return manager.merge(permission);
    }

    @Transactional
    @Override
    public void remove(Permission permission) {
        permission = findById(permission.getId());
        manager.remove(permission);
    }
}
