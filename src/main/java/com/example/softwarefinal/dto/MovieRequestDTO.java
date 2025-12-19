package com.example.softwarefinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequestDTO {
    private String title;
    private Double rating;
    private Long directorId;
    private List<Long> actorIds;
}
