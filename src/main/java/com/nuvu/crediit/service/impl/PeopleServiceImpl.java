package com.nuvu.crediit.service.impl;

import com.nuvu.crediit.model.dto.PeopleDto;
import com.nuvu.crediit.model.entity.People;
import com.nuvu.crediit.repository.PeopleRepository;
import com.nuvu.crediit.service.IPeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleServiceImpl implements IPeopleService {

    Logger logger = LoggerFactory.getLogger(PeopleServiceImpl.class);


    @Autowired
    private PeopleRepository peopleRepository;


    @Override
    public List<PeopleDto> findAllPeople() {
        List<PeopleDto> peopleList = new ArrayList<>();
        try {
            List<People> entityList = peopleRepository.findAll();
            ModelMapper mapper = new ModelMapper();
            entityList.forEach(p -> peopleList.add(mapper.map(p, PeopleDto.class)));
        }catch (Exception e) {
            logger.error("Error in findAll People {}", e.getMessage());
        }
        return peopleList;
    }
}
