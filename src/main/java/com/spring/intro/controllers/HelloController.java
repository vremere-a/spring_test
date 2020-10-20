package com.spring.intro.controllers;

import com.spring.intro.dto.UserResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String seyHello() {
        return "Hello123";
    }

    @GetMapping("/userDto")
    public UserResponseDto getUser() {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName("Arts");
        userResponseDto.setEmail("avremere@ukr.net");
        return userResponseDto;
    }
}
