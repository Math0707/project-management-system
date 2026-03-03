package com.zosh.controller;

import com.zosh.modal.User;
import com.zosh.repository.UserRepository;
import com.zosh.service.CustomeUserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomeUserDetailsImpl customeUserDetails;

    @PostMapping("/signup")
    public ResponseEntity<User>createUserHandler(@RequestBody User user) throws Exception {

        User isUserExist=userRepository.findByEmail(user.getEmail());

        if(isUserExist!=null){
            throw new Exception("email already exist with another account");

        }

        User createdUser=new User();
        createdUser.setPassword(passwordEncoder.encode(user.getPassword()));
        createdUser.setEmail(user.getEmail());
        createdUser.setFullName(user.getFullName());

        User saveUser=userRepository.save(createdUser);

        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

}