package com.example.softwarefinal.service;

import com.example.softwarefinal.dto.ActorDTO;

import java.util.List;

public interface ActorService {
    List<ActorDTO> getAll();
    ActorDTO getById(Long id);
    ActorDTO create(ActorDTO actorDTO);
    ActorDTO update(Long id, ActorDTO actorDTO);
    void delete(Long id);
}
