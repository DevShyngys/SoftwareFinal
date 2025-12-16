package com.example.softwarefinal.mapper;

import com.example.softwarefinal.dto.MovieDTO;
import com.example.softwarefinal.model.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DirectorMapper.class, ActorMapper.class})
public interface MovieMapper {
    MovieDTO toDto(Movie movie);
    Movie toEntity(MovieDTO movieDTO);

    List<MovieDTO> toDtoList(List<Movie> movies);
}
