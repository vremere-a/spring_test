package com.spring.intro;

import com.spring.intro.config.AppConfig;
import com.spring.intro.model.User;
import com.spring.intro.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log4j
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
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

        userService.listUsers().forEach(log::info);
    }
}
