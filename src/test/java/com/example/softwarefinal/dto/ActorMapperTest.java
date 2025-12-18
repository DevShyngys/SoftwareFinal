package com.example.softwarefinal.dto;

import com.example.softwarefinal.mapper.ActorMapper;
import com.example.softwarefinal.model.Actor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class ActorMapperTest {

    @Autowired
    private ActorMapper actorMapper;

    @Test
    void convertEntityToDtoTest() {
        Actor actor = new Actor(1L, "Frank", 12);
        ActorDTO actorDTO = actorMapper.toDto(actor);

        Assertions.assertNotNull(actorDTO);
        Assertions.assertEquals(actor.getId(), actorDTO.getId());
        Assertions.assertEquals(actor.getName(), actorDTO.getName());
        Assertions.assertEquals(actor.getAge(), actorDTO.getAge());
    }

    @Test
    void convertDtoToEntityTest() {
        ActorDTO actorDTO = new ActorDTO(1L, "Banan", 23);
        Actor actor = actorMapper.toEntity(actorDTO);

        Assertions.assertNotNull(actor);
        Assertions.assertEquals(actorDTO.getId(), actor.getId());
        Assertions.assertEquals(actorDTO.getName(), actor.getName());
        Assertions.assertEquals(actorDTO.getAge(), actor.getAge());
    }

    @Test
    void convertEntityListToDtoListTest() {
        List<Actor> actorList = new ArrayList<>();
        actorList.add(new Actor(1L, "Magzhan", 32));
        actorList.add(new Actor(2L, "Ybyrai", 43));
        actorList.add(new Actor(3L, "Magzhan", 34));

        List<ActorDTO> dtoList = actorMapper.toDtoList(actorList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(actorList.size(), dtoList.size());

        for (int i = 0; i < actorList.size(); i++) {
            Actor actor = actorList.get(i);
            ActorDTO actorDTO = dtoList.get(i);

            Assertions.assertNotNull(actorDTO);
            Assertions.assertEquals(actor.getId(), actorDTO.getId());
            Assertions.assertEquals(actor.getName(), actorDTO.getName());
            Assertions.assertEquals(actor.getAge(), actorDTO.getAge());
        }
    }
}
