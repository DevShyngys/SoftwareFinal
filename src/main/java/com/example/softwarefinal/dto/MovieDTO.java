package com.example.softwarefinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private Long id;
    private String title;
    private double rating;
    private DirectorDTO director;
    private List<ActorDTO> actors;
}
