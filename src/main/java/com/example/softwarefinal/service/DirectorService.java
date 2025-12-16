package com.example.softwarefinal.service;

import com.example.softwarefinal.dto.DirectorDTO;

import java.util.List;

public interface DirectorService {
    List<DirectorDTO> getAll();
    DirectorDTO getById(Long id);
    DirectorDTO create(DirectorDTO directorDTO);
    DirectorDTO update(Long id, DirectorDTO directorDTO);
    void delete(Long id);
}
