package com.example.softwarefinal.mapper;

import com.example.softwarefinal.dto.ActorDTO;
import com.example.softwarefinal.dto.MovieDTO;
import com.example.softwarefinal.model.Actor;
import com.example.softwarefinal.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {DirectorMapper.class, ActorMapper.class})
public interface MovieMapper {

    @Mapping(source = "director", target = "director")
    @Mapping(source = "actors", target = "actors", qualifiedByName = "mapActors")
    MovieDTO toDto(Movie movie);

    @Mapping(source = "director", target = "director")
    @Mapping(source = "actors", target = "actors")
    Movie toEntity(MovieDTO movieDTO);

    List<MovieDTO> toDtoList(List<Movie> movies);

    @Named("mapActors")
    default List<ActorDTO> mapActors(List<Actor> actors) {
        if (actors == null) return null;
        return actors.stream()
                .map(a -> new ActorDTO(a.getId(), a.getName(), a.getAge()))
                .collect(Collectors.toList());
    }
}
