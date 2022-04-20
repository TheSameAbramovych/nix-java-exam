package ua.com.alevel.nixjavaexam.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthRequest {
    private String login;
    private String password;
}
