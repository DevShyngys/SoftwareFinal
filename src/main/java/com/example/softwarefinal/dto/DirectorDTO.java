package com.example.softwarefinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDTO {
    private Long id;
    private String name;
    private int age;
    private List<MovieDTO> movies;

    public DirectorDTO(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
