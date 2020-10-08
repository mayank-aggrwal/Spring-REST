package com.may.rest.service;

import com.may.rest.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class CrudService<T extends BaseEntity, ID extends Serializable, R extends JpaRepository<T, ID>> {

    protected final R repository;

    protected CrudService(R repository) {
        this.repository = repository;
    }

    public T get(ID id) {
        Optional<T> byId = repository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            //TODO need to customize exception
            throw new RuntimeException("USER_NOT_FOUND");
        }
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }

}
