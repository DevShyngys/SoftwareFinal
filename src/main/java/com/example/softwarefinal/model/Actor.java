package com.example.softwarefinal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "actors")
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @ManyToMany(mappedBy = "actors")
    @JsonBackReference
    private List<Movie> movies;

    public Actor(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
