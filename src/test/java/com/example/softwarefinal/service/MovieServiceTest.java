package com.example.softwarefinal.service;

import com.example.softwarefinal.dto.MovieDTO;
import com.example.softwarefinal.model.Movie;
import com.example.softwarefinal.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class MovieServiceTest {
    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    @Transactional
    void getAllTest() {
        movieRepository.save(new Movie(null, "Movie1", 8.5, null, null));
        movieRepository.save(new Movie(null, "Movie2", 7.8, null, null));

        List<MovieDTO> result = movieService.getAll();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.size() >= 2);

        for (MovieDTO dto : result) {
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getTitle());
            Assertions.assertNotNull(dto.getRating());
        }
    }

    @Test
    @Transactional
    void getByIdTest() {
        Movie saved = movieRepository.save(new Movie(null, "Movie3", 9.2, null, null));

        MovieDTO dto = movieService.getById(saved.getId());

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(saved.getId(), dto.getId());
        Assertions.assertEquals(saved.getTitle(), dto.getTitle());
        Assertions.assertEquals(saved.getRating(), dto.getRating());

        // Проверяем, что при неправильном ID выбрасывается исключение
        Assertions.assertThrows(RuntimeException.class, () -> movieService.getById(-1L));
    }

    @Test
    @Transactional
    void createTest() {
        MovieDTO input = new MovieDTO(null, "NewMovie", 8.0, null, null);

        MovieDTO created = movieService.create(input);

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals(input.getTitle(), created.getTitle());
        Assertions.assertEquals(input.getRating(), created.getRating());
    }

    @Test
    @Transactional
    void updateTest() {
        Movie saved = movieRepository.save(new Movie(null, "OldMovie", 6.5, null, null));

        MovieDTO updateDTO = new MovieDTO(saved.getId(), "UpdatedMovie", 8.2, null, null);

        MovieDTO updated = movieService.update(saved.getId(), updateDTO);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals(updateDTO.getTitle(), updated.getTitle());
        Assertions.assertEquals(updateDTO.getRating(), updated.getRating());
    }

    @Test
    @Transactional
    void deleteTest() {
        Movie saved = movieRepository.save(new Movie(null, "MovieToDelete", 5.0, null, null));

        movieService.delete(saved.getId());

        Assertions.assertThrows(RuntimeException.class, () -> movieService.getById(saved.getId()));
    }
}
