package com.example.softwarefinal.service;

import com.example.softwarefinal.dto.MovieDTO;
import com.example.softwarefinal.dto.MovieRequestDTO;
import com.example.softwarefinal.model.Actor;
import com.example.softwarefinal.model.Director;
import com.example.softwarefinal.model.Movie;
import com.example.softwarefinal.repository.ActorRepository;
import com.example.softwarefinal.repository.DirectorRepository;
import com.example.softwarefinal.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private ActorRepository actorRepository;

    private Director savedDirector;
    private Actor savedActor1;
    private Actor savedActor2;

    @BeforeEach
    void setup() {
        savedDirector = directorRepository.save(new Director(null, "Nolan", 52));
        savedActor1 = actorRepository.save(new Actor(null, "Leonardo", 48));
        savedActor2 = actorRepository.save(new Actor(null, "Joseph", 41));
    }

    @Test
    @Transactional
    void getAllTest() {
        Movie movie1 = new Movie(null, "Movie1", 8.5, savedDirector, Arrays.asList(savedActor1, savedActor2));
        Movie movie2 = new Movie(null, "Movie2", 7.8, savedDirector, Arrays.asList(savedActor1));
        movieRepository.save(movie1);
        movieRepository.save(movie2);

        List<MovieDTO> result = movieService.getAll();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.size() >= 2);

        for (MovieDTO dto : result) {
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getTitle());
            Assertions.assertNotNull(dto.getRating());
            Assertions.assertNotNull(dto.getDirector());
            Assertions.assertNotNull(dto.getActors());
        }
    }

    @Test
    @Transactional
    void getByIdTest() {
        Movie saved = movieRepository.save(new Movie(null, "Movie3", 9.2, savedDirector, Arrays.asList(savedActor1, savedActor2)));

        MovieDTO dto = movieService.getById(saved.getId());

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(saved.getId(), dto.getId());
        Assertions.assertEquals(saved.getTitle(), dto.getTitle());
        Assertions.assertEquals(saved.getRating(), dto.getRating());

        Assertions.assertThrows(RuntimeException.class, () -> movieService.getById(-1L));
    }

    @Test
    @Transactional
    void createTest() {
        MovieRequestDTO request = new MovieRequestDTO();
        request.setTitle("NewMovie");
        request.setRating(8.0);
        request.setDirectorId(savedDirector.getId());
        request.setActorIds(Arrays.asList(savedActor1.getId(), savedActor2.getId()));

        MovieDTO created = movieService.create(request);

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals(request.getTitle(), created.getTitle());
        Assertions.assertEquals(request.getRating(), created.getRating());
        Assertions.assertEquals(savedDirector.getId(), created.getDirector().getId());
        Assertions.assertEquals(2, created.getActors().size());
    }

    @Test
    @Transactional
    void updateTest() {
        Movie saved = movieRepository.save(new Movie(null, "OldMovie", 6.5, savedDirector, Arrays.asList(savedActor1)));

        MovieRequestDTO request = new MovieRequestDTO();
        request.setTitle("UpdatedMovie");
        request.setRating(8.2);
        request.setDirectorId(savedDirector.getId());
        request.setActorIds(Arrays.asList(savedActor2.getId()));

        MovieDTO updated = movieService.update(saved.getId(), request);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals(request.getTitle(), updated.getTitle());
        Assertions.assertEquals(request.getRating(), updated.getRating());
        Assertions.assertEquals(1, updated.getActors().size());
        Assertions.assertEquals(savedActor2.getId(), updated.getActors().get(0).getId());
    }

    @Test
    @Transactional
    void deleteTest() {
        Movie saved = movieRepository.save(new Movie(null, "MovieToDelete", 5.0, savedDirector, Arrays.asList(savedActor1)));

        movieService.delete(saved.getId());

        Assertions.assertThrows(RuntimeException.class, () -> movieService.getById(saved.getId()));
    }
}
