package com.nuvu.crediit.service;

import com.nuvu.crediit.model.dto.PeopleDto;

import java.util.List;

public interface IPeopleService {

    List<PeopleDto> findAllPeople();
}
