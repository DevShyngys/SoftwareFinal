package com.example.softwarefinal.controller;

import com.example.softwarefinal.dto.MovieDTO;
import com.example.softwarefinal.dto.MovieRequestDTO;
import com.example.softwarefinal.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieServiceImpl movieService;

    @PostMapping
    public MovieDTO createMovie(@RequestBody MovieRequestDTO request) {
        return movieService.create(request);
    }

    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public MovieDTO getById(@PathVariable Long id) {
        return movieService.getById(id);
    }

    @PutMapping("/{id}")
    public MovieDTO updateById(@PathVariable Long id, @RequestBody MovieRequestDTO request) {
        return movieService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        movieService.delete(id);
    }
}
