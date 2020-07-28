package com.nuvu.crediit.service.impl;

import com.nuvu.crediit.model.dto.UserDto;
import com.nuvu.crediit.model.entity.People;
import com.nuvu.crediit.model.entity.User;
import com.nuvu.crediit.repository.UserRepository;
import com.nuvu.crediit.util.Constant;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s)
            throws UsernameNotFoundException {
        return userRepository.findByUserName(s);
    }

    public String createUser(UserDto userDto) {
        String message = Constant.ERROR;
        try {
            if (userRepository.findByUserName(userDto.getUserName()) == null) {
                ModelMapper mapper = new ModelMapper();
                User user = mapper.map(userDto, User.class);
                user.setPassword(passwordEncoder.encode(userDto.getPassword()));
                userRepository.save(user);
                message = Constant.SAVE_USER;
            } else {
                message = Constant.DUPLICATED_USER;
            }
        } catch (Exception e) {
            logger.error("Error in cretePeople People {}", e.getMessage());

        }
        return message;
    }
}
