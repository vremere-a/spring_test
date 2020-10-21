package com.spring.intro.controllers;

import com.spring.intro.config.AppConfig;
import com.spring.intro.dto.UserResponseDto;
import com.spring.intro.model.User;
import com.spring.intro.service.UserService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j
@RestController
@RequestMapping("/user")
public class UserController {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
    UserService userService = context.getBean(UserService.class);

    @GetMapping("/inject")
    public void inject() {
        log.info("Start to inject");
        User tito = new User();
        tito.setFirstName("Tito");
        tito.setLastName("Ortiz");
        tito.setEmail("tito.ortiz@ex.ua");
        userService.add(tito);
        User chuck = new User();
        chuck.setFirstName("Chuck");
        chuck.setLastName("Liddel");
        chuck.setEmail("chuck.liddel@ex.ua");
        userService.add(chuck);
        User justin = new User();
        justin.setFirstName("JUSTIN");
        justin.setLastName("GAETHJE");
        justin.setEmail("j.g@ex.ua");
        userService.add(justin);
        User tony = new User();
        tony.setFirstName("TONY");
        tony.setLastName("FERGUSON");
        tony.setEmail("t.f@ex.ua");
        userService.add(tony);
        log.info("Injecting ready");
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> listOfUsersDto = new ArrayList<>();
        for (User user : userService.listUsers()) {
            listOfUsersDto.add(mapUserResponseDto(user));
        }
        return listOfUsersDto;
    }

    @GetMapping(value = "/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return mapUserResponseDto(userService.getById(userId));
    }

    public UserResponseDto mapUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getFirstName());
        userResponseDto.setSurname(user.getLastName());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
