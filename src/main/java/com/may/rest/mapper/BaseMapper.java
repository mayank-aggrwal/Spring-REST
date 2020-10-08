package com.may.rest.mapper;

import com.may.rest.dto.CrudDto;
import com.may.rest.entity.BaseEntity;

import java.util.List;

public interface BaseMapper<T extends BaseEntity, D extends CrudDto> {
    D toDto(T entity);
    T fromDto(D dto);
    List<D> toDto(List<T> entities);
    List<T> fromDto(List<D> dto);
}
