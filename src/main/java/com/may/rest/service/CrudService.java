package com.may.rest.service;

import com.may.rest.dto.CrudDto;
import com.may.rest.entity.BaseEntity;
import com.may.rest.exception.ObjectNotFoundException;
import com.may.rest.mapper.BaseMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class CrudService<T extends BaseEntity, D extends CrudDto,
        ID extends Serializable, R extends JpaRepository<T, ID>, M extends BaseMapper<T, D>> {

    protected final R repository;
    protected final M mapper;

    protected CrudService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public D get(ID id) {
        Optional<T> byId = repository.findById(id);
        if (byId.isPresent()) {
            return mapper.toDto(byId.get());
        } else {
            throw new ObjectNotFoundException("USER_NOT_FOUND");
        }
    }

    public List<D> getAll() {
        return mapper.toDto(repository.findAll());
    }

    public D save(D dto) {
        T entity = mapper.fromDto(dto);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }

}
