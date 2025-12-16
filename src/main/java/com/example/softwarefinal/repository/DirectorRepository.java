package com.example.softwarefinal.repository;

import com.example.softwarefinal.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends  JpaRepository<Director, Long> {
}
