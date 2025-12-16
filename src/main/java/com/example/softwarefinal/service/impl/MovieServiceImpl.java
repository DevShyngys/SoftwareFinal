package com.example.softwarefinal.service.impl;

import com.example.softwarefinal.dto.MovieDTO;
import com.example.softwarefinal.mapper.MovieMapper;
import com.example.softwarefinal.model.Movie;
import com.example.softwarefinal.repository.MovieRepository;
import com.example.softwarefinal.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    @Override
    public MovieDTO create(MovieDTO movieDTO){
        Movie movie = movieMapper.toEntity(movieDTO);
        Movie saved = movieRepository.save(movie);
        return movieMapper.toDto(saved);
    }

    @Override
    public List<MovieDTO> getAll(){
        return movieMapper.toDtoList(movieRepository.findAll());
    }

    @Override
    public MovieDTO getById(Long id){
        return movieMapper.toDto(movieRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Movie is not found with this id" + id)));
    }

    @Override
    public MovieDTO update(Long id, MovieDTO movieDTO){
        Movie existing = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie is not found with this id" + id));
        existing.setTitle(movieDTO.getTitle());
        existing.setRating(movieDTO.getRating());
        Movie updated = movieRepository.save(existing);

        return movieMapper.toDto(updated);
    }

    @Override
    public void delete(Long id){
        movieRepository.deleteById(id);
    }
}
