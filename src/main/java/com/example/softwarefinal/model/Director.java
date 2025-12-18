package com.example.softwarefinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "directors")
@AllArgsConstructor
@NoArgsConstructor
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movie> movies;

    public Director(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
