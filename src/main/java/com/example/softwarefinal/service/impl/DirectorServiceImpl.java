package com.example.softwarefinal.service.impl;

import com.example.softwarefinal.dto.DirectorDTO;
import com.example.softwarefinal.mapper.DirectorMapper;
import com.example.softwarefinal.model.Director;
import com.example.softwarefinal.repository.DirectorRepository;
import com.example.softwarefinal.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {
    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;

    @Override
    public DirectorDTO create(DirectorDTO directorDTO){
        Director director =directorMapper.toEntity(directorDTO);
        Director saved = directorRepository.save(director);
        return directorMapper.toDto(saved);
    }

    @Override
    public List<DirectorDTO> getAll(){
        return directorMapper.toDtoList(directorRepository.findAll());
    }

    @Override
    public DirectorDTO getById(Long id){
        Director director = directorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Director is not found with this id" + id));
        return directorMapper.toDto(director);
    }

    @Override
    public DirectorDTO update(Long id, DirectorDTO directorDTO){
        Director existing = directorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Director is not found with this id" + id));

        existing.setName(directorDTO.getName());
        existing.setAge(directorDTO.getAge());
        Director updated = directorRepository.save(existing);

        return directorMapper.toDto(updated);
    }

    @Override
    public void delete(Long id){
        directorRepository.deleteById(id);
    }
}
