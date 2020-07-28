package com.nuvu.crediit.service;

import com.nuvu.crediit.model.dto.PeopleDto;
import com.nuvu.crediit.model.dto.RequestAddCard;
import com.nuvu.crediit.model.entity.People;

import java.util.List;

public interface IPeopleService {

    List<PeopleDto> findAllPeople();

    String cretePeople(PeopleDto peopleDto);

    PeopleDto finByIdNumberAndIdType(Long idNumber, Long idType);

    String editPerson (PeopleDto peopleDto);

    String addCard(RequestAddCard requestAddCard);

    String modifyCard(RequestAddCard requestAddCard);

    String deleteCard(Long idNumberCard, Long idNumber, Long idType);

}
