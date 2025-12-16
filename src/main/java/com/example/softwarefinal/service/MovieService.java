package com.example.softwarefinal.service;

import com.example.softwarefinal.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    List<MovieDTO> getAll();
    MovieDTO getById(Long id);
    MovieDTO create(MovieDTO movieDTO);
    MovieDTO update(Long id, MovieDTO movieDTO);
    void delete(Long id);
}
