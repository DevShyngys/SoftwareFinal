package com.example.softwarefinal.mappertests;

import com.example.softwarefinal.dto.DirectorDTO;
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
    void EntityToDTOtest()
    {
        Director director = new Director(1L, "Josh", 52, new ArrayList<>());
        DirectorDTO directorDTO = directorMapper.toDto(director);
        Assertions.assertNotNull(directorDTO);

        Assertions.assertEquals(director,directorDTO);

        Assertions.assertNotNull(directorDTO.getId());
        Assertions.assertNotNull(directorDTO.getName());
        Assertions.assertNotNull(directorDTO.getAge());
    }

    @Test
    void DTOtoEntityTest(){
        DirectorDTO directorDTO = new DirectorDTO(1L, "Johan", 30, new ArrayList<>());

        Director director = directorMapper.toEntity(directorDTO);

        Assertions.assertNotNull(director);

        Assertions.assertEquals(directorDTO,director);

        Assertions.assertNotNull(director.getName());
        Assertions.assertNotNull(director.getId());
        Assertions.assertNotNull(director.getAge());
    }

    @Test
    void EntityListToDtoListTest(){
        List<Director> directorList = new ArrayList<>();
        directorList.add(new Director(1L, "Stan Lee", 90, new ArrayList<>()));
        directorList.add(new Director(2L, "Nurlan Koyanbaev", 43, new ArrayList<>()));
        directorList.add(new Director(3L, "Joana Rouling", 34, new ArrayList<>()));

        List<DirectorDTO> dtoList = directorMapper.toDtoList(directorList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(directorList.size(),dtoList.size());

        for(int i = 0; i < directorList.size(); i++){
            DirectorDTO directorDTO = dtoList.get(i);
            Director director = directorList.get(i);

            Assertions.assertNotNull(directorDTO);

            Assertions.assertEquals(director,directorDTO);
            Assertions.assertEquals(director.getId(),directorDTO.getId());
            Assertions.assertEquals(director.getName(),directorDTO.getName());
            Assertions.assertEquals(director.getAge(),directorDTO.getAge());

            Assertions.assertNotNull(directorDTO.getId());
            Assertions.assertNotNull(directorDTO.getName());
            Assertions.assertNotNull(directorDTO.getAge());
        }
    }
}
