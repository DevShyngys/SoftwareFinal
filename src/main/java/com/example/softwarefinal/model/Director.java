package com.example.softwarefinal.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "directors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;

    public Director(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
