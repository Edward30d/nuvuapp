package com.nuvu.crediit.controller;

import com.nuvu.crediit.model.dto.PeopleDto;
import com.nuvu.crediit.model.dto.RequestAddCard;
import com.nuvu.crediit.model.dto.ResponseGeneric;
import com.nuvu.crediit.service.IPeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/data/v1/people/")
@CrossOrigin
public class PeopleController {

    Logger logger = LoggerFactory.getLogger(PeopleController.class);

    @Autowired
    private IPeopleService peopleService;

    @Autowired
    private PasswordEncoder bc;


    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<PeopleDto>> getAllPeople(){
        try {
            List<PeopleDto> response = peopleService.findAllPeople();
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            logger.error("Error in getAllPeople {} ", e.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ResponseGeneric> createPeopleService(@RequestBody PeopleDto peopleDto){
        try {
            ResponseGeneric response = new ResponseGeneric();
            response.setMessage(peopleService.cretePeople(peopleDto));
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            logger.error("Error in createPeopleService {} ", e.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping(value = "find", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<PeopleDto> findByIdAndNumber(@RequestParam Long idNumber, Long idType){
        try {
            PeopleDto response = peopleService.finByIdNumberAndIdType(idNumber,idType);
            if(response != null){
                return ResponseEntity.ok(response);
            }
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            logger.error("Error in findByIdAndNumber {} ", e.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping(value = "edit", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ResponseGeneric> editPerson( @RequestBody PeopleDto peopleDto){
        try {
            ResponseGeneric response = new ResponseGeneric();
            response.setMessage(peopleService.editPerson(peopleDto));
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            logger.error("Error in editPerson {} ", e.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping(value = "addCard", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ResponseGeneric> addCard (@RequestBody RequestAddCard requestAddCard) {
        try {
            ResponseGeneric response = new ResponseGeneric();
            response.setMessage(peopleService.addCard(requestAddCard));
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            logger.error("Error in addCard {} ", e.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
