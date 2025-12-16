package com.example.softwarefinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorDTO {
    private Long id;
    private String name;
    private int age;
    private List<MovieDTO> movies;
}
