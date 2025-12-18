package com.example.softwarefinal.mappertests;

import com.example.softwarefinal.dto.ActorDTO;
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
    void EntityToDTOtest()
    {
        Actor actor = new Actor(1L, "Frank", 12, new ArrayList<>());
        ActorDTO actorDTO = actorMapper.toDto(actor);
        Assertions.assertNotNull(actorDTO);

        Assertions.assertEquals(actor,actorDTO);

        Assertions.assertNotNull(actorDTO.getId());
        Assertions.assertNotNull(actorDTO.getName());
        Assertions.assertNotNull(actorDTO.getAge());
    }

    @Test
    void DTOtoEntityTest(){
        ActorDTO actorDTO = new ActorDTO(1L, "Banan", 23, new ArrayList<>());

        Actor actor = actorMapper.toEntity(actorDTO);

        Assertions.assertNotNull(actor);

        Assertions.assertEquals(actorDTO,actor);

        Assertions.assertNotNull(actor.getName());
        Assertions.assertNotNull(actor.getId());
        Assertions.assertNotNull(actor.getAge());
    }

    @Test
    void EntityListToDtoListTest(){
        List<Actor> actorList = new ArrayList<>();
        actorList.add(new Actor(1L, "Magzhan", 32, new ArrayList<>()));
        actorList.add(new Actor(2L, "Ybyrai", 43, new ArrayList<>()));
        actorList.add(new Actor(3L, "Magzhan", 34, new ArrayList<>()));

        List<ActorDTO> dtoList = actorMapper.toDtoList(actorList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(actorList.size(),dtoList.size());

        for(int i = 0; i < actorList.size(); i++){
            ActorDTO actorDTO = dtoList.get(i);
            Actor actor = actorList.get(i);

            Assertions.assertNotNull(actorDTO);

            Assertions.assertEquals(actor,actorDTO);
            Assertions.assertEquals(actor.getId(),actorDTO.getId());
            Assertions.assertEquals(actor.getName(),actorDTO.getName());
            Assertions.assertEquals(actor.getAge(),actorDTO.getAge());

            Assertions.assertNotNull(actorDTO.getId());
            Assertions.assertNotNull(actorDTO.getName());
            Assertions.assertNotNull(actorDTO.getAge());
        }
    }
}
