package com.spring.intro.dto;

import com.spring.intro.model.User;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserResponseDto {
    @Autowired
    @Setter
    private User user;
    private String name;
    private String surname;
    private String email;
}
