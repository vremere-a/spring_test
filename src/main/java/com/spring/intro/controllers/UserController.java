package com.spring.intro.controllers;

import com.spring.intro.dto.UserResponseDto;
import com.spring.intro.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

//    @RequestMapping(value = "/get{id}", method = RequestMethod.GET)
//    public String get(@PathVariable Long id, @RequestParam String message) {
//        return "user: " + id + ". Message: " + message;
//    }

    public UserResponseDto setUser() {
        UserResponseDto userResponseDto = context.getBean(UserResponseDto.class);
        userResponseDto.setName("Tito");
        userResponseDto.setEmail("tito.ortiz@ex.ua");
        return userResponseDto;
    }
}
