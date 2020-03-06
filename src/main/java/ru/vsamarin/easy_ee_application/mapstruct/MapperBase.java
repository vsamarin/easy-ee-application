package ru.vsamarin.easy_ee_application.mapstruct;

import ru.vsamarin.easy_ee_application.dto.EntityDto;
import ru.vsamarin.easy_ee_application.entity.EntityBase;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public interface MapperBase<Entity extends EntityBase, Dto extends EntityDto> {

    Entity toEntity(Dto dto);

    Dto toDto(Entity entity);

    default List<Dto> toDto(Collection<Entity> entityList) {
        return entityList == null ? Collections.emptyList() : entityList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    default List<Entity> toEntity(Collection<Dto> entityList) {
        return entityList == null ? Collections.emptyList() : entityList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

}