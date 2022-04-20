package ua.com.alevel.nixjavaexam.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class RegistrationRequest {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
}
