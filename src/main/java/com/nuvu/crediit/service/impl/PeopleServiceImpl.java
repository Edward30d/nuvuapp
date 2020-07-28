package com.nuvu.crediit.service.impl;

import com.nuvu.crediit.model.dto.PeopleDto;
import com.nuvu.crediit.model.dto.RequestAddCard;
import com.nuvu.crediit.model.entity.CategoryCard;
import com.nuvu.crediit.model.entity.CreditCard;
import com.nuvu.crediit.model.entity.People;
import com.nuvu.crediit.repository.CategoryCardRespository;
import com.nuvu.crediit.repository.CreditCardRepository;
import com.nuvu.crediit.repository.PeopleRepository;
import com.nuvu.crediit.service.IPeopleService;
import com.nuvu.crediit.util.Constant;
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

    ModelMapper mapper = new ModelMapper();

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private CategoryCardRespository categoryCardRespository;

    @Autowired
    private CreditCardRepository creditCardRepository;


    @Override
    public List<PeopleDto> findAllPeople() {
        List<PeopleDto> peopleList = new ArrayList<>();
        try {
            List<People> entityList = peopleRepository.findAll();
            entityList.forEach(p -> peopleList.add(mapper.map(p, PeopleDto.class)));
        }catch (Exception e) {
            logger.error("Error in findAll People {}", e.getMessage());
        }
        return peopleList;
    }

    @Override
    public String cretePeople(PeopleDto peopleDto) {
        String message = Constant.ERROR;
        try {
            if(peopleRepository.findByIdNumberAndIdType(peopleDto.getIdNumber(), peopleDto.getIdType())
                    .isEmpty()){
                People people = mapper.map(peopleDto, People.class);
                peopleRepository.save(people);
                message = Constant.SAVE_PEOPLE;
            } else {
                message = Constant.DUPLICATED_PEOPLE;
            }
        }catch (Exception e) {
            logger.error("Error in cretePeople People {}", e.getMessage());

        }
        return message;
    }

    @Override
    public PeopleDto finByIdNumberAndIdType(Long idNumber, Long idType) {
        try {
            List<People> entityList = peopleRepository.findByIdNumberAndIdType(idNumber,idType);
            if(!entityList.isEmpty()){
                return mapper.map(entityList.get(0), PeopleDto.class);
            }
        } catch (Exception e) {
            logger.error("Error in finByIdNumberAndIdType People {}", e.getMessage());
        }
        return null;
    }

    @Override
    public String editPerson(PeopleDto peopleDto) {
        String message = Constant.ERROR;
        try {
            List<People> peopleList = peopleRepository
                    .findByIdNumberAndIdType(peopleDto.getIdNumber(), peopleDto.getIdType());
            if(peopleList.isEmpty()){
                message = Constant.PEOPLE_NOT_EXISTS;
            } else {
                People people = peopleList.get(0);
                people.setAddress(peopleDto.getAddress());
                people.setEmail(peopleDto.getEmail());
                people.setLastName(peopleDto.getLastName());
                people.setPhoneNumber(peopleDto.getPhoneNumber());
                peopleRepository.save(people);
                message = Constant.EDIT_PEOPLE;
            }
        }catch (Exception e) {
            logger.error("Error in cretePeople People {}", e.getMessage());
        }
        return message;
    }

    @Override
    public String addCard(RequestAddCard requestAddCard) {
        try {
            List<People> peopleList = peopleRepository
                    .findByIdNumberAndIdType(requestAddCard.getPeople().getIdNumber()
                            , requestAddCard.getPeople().getIdType());
            if(peopleList.isEmpty()){
                return Constant.PEOPLE_NOT_EXISTS;
            }
            List<CategoryCard> listCategory = categoryCardRespository
                    .findByTypeAndFranchise(requestAddCard.getCard().getType()
                            , requestAddCard.getCard().getFranchise());
            if(listCategory.isEmpty()){
                return Constant.CARD_NOT_EXISTS;
            }
            People people = peopleList.get(0);
            CategoryCard card = listCategory.get(0);
            CreditCard creditCard = new CreditCard();
            creditCard.setCategoryCard(card.getIdCard());
            creditCard.setPeople(people.getIdPeople());
            creditCard.setCsv(requestAddCard.getCard().getCsv());
            creditCard.setDateExpiry(requestAddCard.getCard().getDateExpiry());
            creditCard.setIdNumber(requestAddCard.getCard().getIdNumber());
            creditCard.setBalance(requestAddCard.getCard().getBalance());
            creditCardRepository.save(creditCard);
            return Constant.ADD_CARD;
        }catch (Exception e) {
            logger.error("Error in cretePeople People {}", e.getMessage());
        }
        return Constant.ERROR;
    }


}
