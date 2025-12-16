package com.example.softwarefinal.mapper;

import com.example.softwarefinal.dto.DirectorDTO;
import com.example.softwarefinal.model.Director;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    DirectorDTO toDto(Director director);
    Director toEntity(DirectorDTO directorDTO);

    List<DirectorDTO> toDtoList(List<Director> directors);
}
