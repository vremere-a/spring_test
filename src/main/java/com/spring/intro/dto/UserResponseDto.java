package com.spring.intro.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserResponseDto {
    private String name;
    private String surname;
    private String email;
}
