package com.example.softwarefinal.controller;

import com.example.softwarefinal.dto.DirectorDTO;
import com.example.softwarefinal.service.impl.DirectorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/directors")
public class DirectorController {
    private final DirectorServiceImpl directorService;

    @PostMapping
    public DirectorDTO createDirector(@RequestBody DirectorDTO directorDTO){
        return directorService.create(directorDTO);
    }

    @GetMapping
    public List<DirectorDTO> getAllDirectors(){
        return directorService.getAll();
    }

    @GetMapping("/{id}")
    public DirectorDTO getById(@PathVariable Long id){
        return directorService.getById(id);
    }

    @PostMapping("/{id}")
    public DirectorDTO updateById(@PathVariable Long id, @RequestBody DirectorDTO directorDTO){
        return directorService.update(id, directorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteByid(@PathVariable Long id){
        directorService.delete(id);
    }
}
