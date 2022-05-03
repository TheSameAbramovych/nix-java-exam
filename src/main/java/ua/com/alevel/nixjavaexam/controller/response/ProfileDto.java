package ua.com.alevel.nixjavaexam.controller.response;

import java.util.Date;

public record ProfileDto(String firstName, String lastName, String email, Date birthDate) {
}
