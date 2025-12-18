package com.example.softwarefinal.dto;

import com.example.softwarefinal.mapper.MovieMapper;
import com.example.softwarefinal.model.Actor;
import com.example.softwarefinal.model.Director;
import com.example.softwarefinal.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class MovieMapperTest {

    @Autowired
    private MovieMapper movieMapper;

    @Test
    void convertEntityToDto() {
        Director director = new Director(1L, "Director1", 55);
        Actor actor1 = new Actor(1L, "Actor1", 30);
        Actor actor2 = new Actor(2L, "Actor2", 40);

        Movie movie = new Movie(1L, "Inception", 8.8, director, List.of(actor1, actor2));

        MovieDTO movieDTO = movieMapper.toDto(movie);

        Assertions.assertNotNull(movieDTO);
        Assertions.assertEquals(movie.getId(), movieDTO.getId());
        Assertions.assertEquals(movie.getTitle(), movieDTO.getTitle());
        Assertions.assertEquals(movie.getRating(), movieDTO.getRating());
        Assertions.assertNotNull(movieDTO.getDirector());
        Assertions.assertEquals(movie.getDirector().getName(), movieDTO.getDirector().getName());
        Assertions.assertEquals(movie.getActors().size(), movieDTO.getActors().size());
    }

    @Test
    void convertDtoToEntity() {
        DirectorDTO directorDTO = new DirectorDTO(1L, "Director1", 48);
        ActorDTO actorDTO1 = new ActorDTO(1L, "Actor1", 30);
        ActorDTO actorDTO2 = new ActorDTO(2L, "Actor2", 40);

        MovieDTO movieDTO = new MovieDTO(1L, "Inception", 8.8, directorDTO, List.of(actorDTO1, actorDTO2));

        Movie movie = movieMapper.toEntity(movieDTO);

        Assertions.assertNotNull(movie);
        Assertions.assertEquals(movieDTO.getId(), movie.getId());
        Assertions.assertEquals(movieDTO.getTitle(), movie.getTitle());
        Assertions.assertEquals(movieDTO.getRating(), movie.getRating());
        Assertions.assertNotNull(movie.getDirector());
        Assertions.assertEquals(movie.getDirector().getName(), movieDTO.getDirector().getName());
        Assertions.assertEquals(movieDTO.getActors().size(), movie.getActors().size());
    }

    @Test
    void convertEntityListToDtoList() {
        Director director1 = new Director(1L, "Director1", 66);
        Director director2 = new Director(2L, "Director2", 79);
        Actor actor1 = new Actor(1L, "Actor1", 30);
        Actor actor2 = new Actor(2L, "Actor2", 40);
        Actor actor3 = new Actor(3L, "Actor3", 50);

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie(1L, "Inception", 8.8, director1, List.of(actor1, actor2)));
        movieList.add(new Movie(2L, "Titanic", 7.8, director2, List.of(actor2, actor3)));

        List<MovieDTO> dtoList = movieMapper.toDtoList(movieList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(movieList.size(), dtoList.size());

        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            MovieDTO movieDTO = dtoList.get(i);

            Assertions.assertNotNull(movieDTO);
            Assertions.assertEquals(movie.getId(), movieDTO.getId());
            Assertions.assertEquals(movie.getTitle(), movieDTO.getTitle());
            Assertions.assertEquals(movie.getRating(), movieDTO.getRating());
            Assertions.assertNotNull(movieDTO.getDirector());
            Assertions.assertEquals(movie.getDirector().getName(), movieDTO.getDirector().getName());
            Assertions.assertEquals(movie.getActors().size(), movieDTO.getActors().size());
        }
    }
}
