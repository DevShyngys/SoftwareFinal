package com.example.softwarefinal.service;

import com.example.softwarefinal.dto.DirectorDTO;
import com.example.softwarefinal.model.Director;
import com.example.softwarefinal.repository.DirectorRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class DirectorServiceTest {

    @Autowired
    private DirectorService directorService;

    @Autowired
    private DirectorRepository directorRepository;

    @Test
    @Transactional
    void getAllTest() {
        directorRepository.save(new Director(null, "Director1", 55, null));
        directorRepository.save(new Director(null, "Director2", 60, null));

        List<DirectorDTO> result = directorService.getAll();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.size() >= 2);

        for (DirectorDTO dto : result) {
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getName());
            Assertions.assertNotNull(dto.getAge());
        }
    }

    @Test
    @Transactional
    void getByIdTest() {
        Director saved = directorRepository.save(new Director(null, "Director3", 45, null));

        DirectorDTO dto = directorService.getById(saved.getId());

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(saved.getId(), dto.getId());
        Assertions.assertEquals(saved.getName(), dto.getName());
        Assertions.assertEquals(saved.getAge(), dto.getAge());

        Assertions.assertThrows(RuntimeException.class, () -> directorService.getById(-1L));
    }

    @Test
    @Transactional
    void createTest() {
        DirectorDTO input = new DirectorDTO(null, "NewDirector", 40, null);

        DirectorDTO created = directorService.create(input);

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals(input.getName(), created.getName());
        Assertions.assertEquals(input.getAge(), created.getAge());
    }

    @Test
    @Transactional
    void updateTest() {
        Director saved = directorRepository.save(new Director(null, "OldDirector", 50, null));

        DirectorDTO updateDTO = new DirectorDTO(saved.getId(), "UpdatedDirector", 55, null);

        DirectorDTO updated = directorService.update(saved.getId(), updateDTO);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals(updateDTO.getName(), updated.getName());
        Assertions.assertEquals(updateDTO.getAge(), updated.getAge());
    }

    @Test
    @Transactional
    void deleteTest() {
        Director saved = directorRepository.save(new Director(null, "DirectorToDelete", 50, null));

        directorService.delete(saved.getId());

        Assertions.assertThrows(RuntimeException.class, () -> directorService.getById(saved.getId()));
    }
}
