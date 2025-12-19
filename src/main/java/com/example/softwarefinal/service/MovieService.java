package com.example.softwarefinal.service;

import com.example.softwarefinal.dto.MovieDTO;
import com.example.softwarefinal.dto.MovieRequestDTO;

import java.util.List;

public interface MovieService {
    List<MovieDTO> getAll();
    MovieDTO getById(Long id);
    MovieDTO create(MovieRequestDTO request);
    MovieDTO update(Long id, MovieRequestDTO request);
    void delete(Long id);
}
