package ua.com.alevel.nixjavaexam.controller.response;

import ua.com.alevel.nixjavaexam.entity.Lesson;

import java.util.Date;
import java.util.Set;

public record DashboardDto(String login, String firstName, String lastName,
                           String email, Date birthDate,
                           Set<Lesson> lessons) {
}
