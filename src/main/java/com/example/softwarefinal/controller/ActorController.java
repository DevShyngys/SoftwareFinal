package com.example.softwarefinal.controller;

import com.example.softwarefinal.dto.ActorDTO;
import com.example.softwarefinal.service.impl.ActorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/actors")
public class ActorController {
    private final ActorServiceImpl actorService;

    @PostMapping
    public ActorDTO createActor(@RequestBody ActorDTO actorDTO){
        return actorService.create(actorDTO);
    }

    @GetMapping
    public List<ActorDTO> getAllActors(){
        return actorService.getAll();
    }

    @GetMapping("/{id}")
    public ActorDTO getById(@PathVariable Long id){
        return actorService.getById(id);
    }

    @PutMapping("/{id}")
    public ActorDTO updateById(@PathVariable Long id, @RequestBody ActorDTO actorDTO){
        return actorService.update(id, actorDTO);
    }

    @DeleteMapping("/{id}")
    public void  deleteById(@PathVariable Long id){
        actorService.delete(id);
    }
}
