package com.nuvu.crediit.controller;

import com.nuvu.crediit.model.dto.ResponseGeneric;
import com.nuvu.crediit.model.dto.UserDto;
import com.nuvu.crediit.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data/v1/user/")
@CrossOrigin
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ResponseGeneric> createPeopleService(@RequestBody UserDto userDto){
        try {
            ResponseGeneric response = new ResponseGeneric();
            response.setMessage(userService.createUser(userDto));
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            logger.error("Error in createPeopleService {} ", e.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
