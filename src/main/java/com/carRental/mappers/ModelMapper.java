package com.carRental.mappers;

import java.util.List;

public interface ModelMapper<Dto, Entity> {

    Dto toDto(Entity entity);
    Entity toEntity(Dto dto);
    List<Dto> allToDtos(List<Entity> entities);
    List<Entity> allToEntities(List<Dto> dtos);
}
