package com.example.softwarefinal.mapper;

import com.example.softwarefinal.dto.ActorDTO;
import com.example.softwarefinal.model.Actor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorDTO toDto(Actor actor);
    Actor toEntity(ActorDTO actorDTO);

    List<ActorDTO> toDtoList(List<Actor> actors);
}
