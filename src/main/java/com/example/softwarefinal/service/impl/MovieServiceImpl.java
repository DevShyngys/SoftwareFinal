package com.example.softwarefinal.service.impl;

import com.example.softwarefinal.dto.ActorDTO;
import com.example.softwarefinal.dto.DirectorDTO;
import com.example.softwarefinal.dto.MovieDTO;
import com.example.softwarefinal.dto.MovieRequestDTO;
import com.example.softwarefinal.mapper.MovieMapper;
import com.example.softwarefinal.model.Actor;
import com.example.softwarefinal.model.Director;
import com.example.softwarefinal.model.Movie;
import com.example.softwarefinal.repository.ActorRepository;
import com.example.softwarefinal.repository.DirectorRepository;
import com.example.softwarefinal.repository.MovieRepository;
import com.example.softwarefinal.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final ActorRepository actorRepository;

    @Override
    public MovieDTO create(MovieRequestDTO request) {
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setRating(request.getRating());

        Director director = directorRepository.findById(request.getDirectorId())
                .orElseThrow(() -> new RuntimeException("Director not found: " + request.getDirectorId()));
        movie.setDirector(director);

        List<Actor> actors = actorRepository.findAllById(request.getActorIds());
        movie.setActors(actors);

        Movie saved = movieRepository.save(movie);
        return movieMapper.toDto(saved);
    }

    @Override
    public List<MovieDTO> getAll() {
        return movieMapper.toDtoList(movieRepository.findAll());
    }

    @Override
    public MovieDTO getById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found: " + id));
        return movieMapper.toDto(movie);
    }

    @Override
    public MovieDTO update(Long id, MovieRequestDTO request) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found: " + id));

        movie.setTitle(request.getTitle());
        movie.setRating(request.getRating());

        Director director = directorRepository.findById(request.getDirectorId())
                .orElseThrow(() -> new RuntimeException("Director not found: " + request.getDirectorId()));
        movie.setDirector(director);

        List<Actor> actors = actorRepository.findAllById(request.getActorIds());
        movie.setActors(actors);

        Movie updated = movieRepository.save(movie);
        return movieMapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
