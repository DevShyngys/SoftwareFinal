package com.example.softwarefinal.service.impl;

import com.example.softwarefinal.dto.ActorDTO;
import com.example.softwarefinal.mapper.ActorMapper;
import com.example.softwarefinal.model.Actor;
import com.example.softwarefinal.repository.ActorRepository;
import com.example.softwarefinal.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    @Override
    public ActorDTO create(ActorDTO actorDTO){
        Actor actor = actorMapper.toEntity(actorDTO);
        Actor saved = actorRepository.save(actor);

        return actorMapper.toDto(saved);
    }

    @Override
    public List<ActorDTO> getAll(){
        return actorMapper.toDtoList(actorRepository.findAll());
    }

    @Override
    public ActorDTO getById(Long id){
        Actor actor = actorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Actor is not found with this id" + id));
        return actorMapper.toDto(actor);
    }

    @Override
    public ActorDTO update(Long id, ActorDTO actorDTO){
        Actor existing = actorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Actor is not found with this id" + id));
        existing.setName(actorDTO.getName());
        existing.setAge(actorDTO.getAge());
        Actor updated = actorRepository.save(existing);

        return actorMapper.toDto(updated);
    }

    @Override
    public void delete(Long id){
        actorRepository.deleteById(id);
    }
}
