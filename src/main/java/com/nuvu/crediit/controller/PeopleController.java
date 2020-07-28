package com.nuvu.crediit.controller;

import com.nuvu.crediit.model.dto.PeopleDto;
import com.nuvu.crediit.service.IPeopleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

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
        bc.encode("123");
        try {
            List<PeopleDto> response = peopleService.findAllPeople();
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            logger.error("Error in getAllPeople {} ", e.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
