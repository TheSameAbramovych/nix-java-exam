package ua.com.alevel.nixjavaexam.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.alevel.nixjavaexam.entity.Role;

import java.util.List;

@AllArgsConstructor
public class UserResponseDto {
    private final String login;
}
