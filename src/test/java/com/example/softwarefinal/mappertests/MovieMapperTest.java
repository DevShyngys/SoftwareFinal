package com.example.softwarefinal.mappertests;

import com.example.softwarefinal.dto.DirectorDTO;
import com.example.softwarefinal.dto.MovieDTO;
import com.example.softwarefinal.mapper.MovieMapper;
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
    void EntityToDTOtest()
    {
        Movie movie = new Movie(1L, "HarryPotter", 9.7, new Director(), new ArrayList<>() );
        MovieDTO movieDTO = movieMapper.toDto(movie);
        Assertions.assertNotNull(movieDTO);

        Assertions.assertEquals(movie,movieDTO);

        Assertions.assertNotNull(movieDTO.getId());
        Assertions.assertNotNull(movieDTO.getTitle());
        Assertions.assertNotNull(movieDTO.getRating());
    }

    @Test
    void DTOtoEntityTest(){
        MovieDTO movieDTO = new MovieDTO(2L, "Up!",8 , new DirectorDTO(), new ArrayList<>());

        Movie movie = movieMapper.toEntity(movieDTO);

        Assertions.assertNotNull(movie);

        Assertions.assertEquals(movieDTO,movie);

        Assertions.assertNotNull(movie.getTitle());
        Assertions.assertNotNull(movie.getId());
        Assertions.assertNotNull(movie.getRating());
    }

    @Test
    void EntityListToDtoListTest(){
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie(1L, "Rocker", 5.6,new Director(), new ArrayList<>()));
        movieList.add(new Movie(2L, "Avengers", 8.9,new Director(), new ArrayList<>()));
        movieList.add(new Movie(3L, "Black Widow", 7.8,new Director(), new ArrayList<>()));

        List<MovieDTO> dtoList = movieMapper.toDtoList(movieList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(movieList.size(),dtoList.size());

        for(int i = 0; i < movieList.size(); i++){
            MovieDTO movieDTO = dtoList.get(i);
            Movie movie = movieList.get(i);

            Assertions.assertNotNull(movieDTO);

            Assertions.assertEquals(movie,movieDTO);
            Assertions.assertEquals(movie.getId(),movieDTO.getId());
            Assertions.assertEquals(movie.getTitle(),movieDTO.getTitle());
            Assertions.assertEquals(movie.getRating(),movieDTO.getRating());

            Assertions.assertNotNull(movieDTO.getId());
            Assertions.assertNotNull(movieDTO.getTitle());
            Assertions.assertNotNull(movieDTO.getRating());
        }
    }
}
