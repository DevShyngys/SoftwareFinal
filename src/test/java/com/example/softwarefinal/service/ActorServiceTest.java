package com.example.softwarefinal.service;

import com.example.softwarefinal.dto.ActorDTO;
import com.example.softwarefinal.model.Actor;
import com.example.softwarefinal.repository.ActorRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class ActorServiceTest {

    @Autowired
    private ActorService actorService;

    @Autowired
    private ActorRepository actorRepository;

    @Test
    @Transactional
    void getAllTest() {
        actorRepository.save(new Actor(null, "Actor1", 30, null));
        actorRepository.save(new Actor(null, "Actor2", 40, null));

        List<ActorDTO> result = actorService.getAll();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.size() >= 2);

        for (ActorDTO dto : result) {
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getName());
            Assertions.assertNotNull(dto.getAge());
        }
    }

    @Test
    @Transactional
    void getByIdTest() {
        Actor saved = actorRepository.save(new Actor(null, "Actor3", 35, null));

        ActorDTO dto = actorService.getById(saved.getId());

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(saved.getId(), dto.getId());
        Assertions.assertEquals(saved.getName(), dto.getName());
        Assertions.assertEquals(saved.getAge(), dto.getAge());

        Assertions.assertThrows(RuntimeException.class, () -> actorService.getById(-1L));
    }

    @Test
    @Transactional
    void createTest() {
        ActorDTO input = new ActorDTO(null, "NewActor", 25, null);

        ActorDTO created = actorService.create(input);

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals(input.getName(), created.getName());
        Assertions.assertEquals(input.getAge(), created.getAge());
    }

    @Test
    @Transactional
    void updateTest() {
        Actor saved = actorRepository.save(new Actor(null, "OldActor", 50, null));

        ActorDTO updateDTO = new ActorDTO(saved.getId(), "UpdatedActor", 55, null);

        ActorDTO updated = actorService.update(saved.getId(), updateDTO);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals(updateDTO.getName(), updated.getName());
        Assertions.assertEquals(updateDTO.getAge(), updated.getAge());
    }

    @Test
    @Transactional
    void deleteTest() {
        Actor saved = actorRepository.save(new Actor(null, "ActorToDelete", 45, null));

        actorService.delete(saved.getId());

        Assertions.assertThrows(RuntimeException.class, () -> actorService.getById(saved.getId()));
    }
}
