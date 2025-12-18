package com.example.softwarefinal.dto;

import com.example.softwarefinal.mapper.DirectorMapper;
import com.example.softwarefinal.model.Director;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class DirectorMapperTest {

    @Autowired
    private DirectorMapper directorMapper;

    @Test
    void convertEntityToDtoTest() {
        Director director = new Director(1L, "Josh", 52);
        DirectorDTO directorDTO = directorMapper.toDto(director);

        Assertions.assertNotNull(directorDTO);
        Assertions.assertEquals(director.getId(), directorDTO.getId());
        Assertions.assertEquals(director.getName(), directorDTO.getName());
        Assertions.assertEquals(director.getAge(), directorDTO.getAge());
    }

    @Test
    void convertDtoToEntityTest() {
        DirectorDTO directorDTO = new DirectorDTO(1L, "Johan", 30);
        Director director = directorMapper.toEntity(directorDTO);

        Assertions.assertNotNull(director);
        Assertions.assertEquals(directorDTO.getId(), director.getId());
        Assertions.assertEquals(directorDTO.getName(), director.getName());
        Assertions.assertEquals(directorDTO.getAge(), director.getAge());
    }

    @Test
    void convertEntityListToDtoListTest() {
        List<Director> directorList = new ArrayList<>();
        directorList.add(new Director(1L, "Stan Lee", 90));
        directorList.add(new Director(2L, "Nurlan Koyanbaev", 43));
        directorList.add(new Director(3L, "Joana Rouling", 34));

        List<DirectorDTO> dtoList = directorMapper.toDtoList(directorList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(directorList.size(), dtoList.size());

        for (int i = 0; i < directorList.size(); i++) {
            Director director = directorList.get(i);
            DirectorDTO directorDTO = dtoList.get(i);

            Assertions.assertNotNull(directorDTO);
            Assertions.assertEquals(director.getId(), directorDTO.getId());
            Assertions.assertEquals(director.getName(), directorDTO.getName());
            Assertions.assertEquals(director.getAge(), directorDTO.getAge());
        }
    }
}
