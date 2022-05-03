package ua.com.alevel.nixjavaexam.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.nixjavaexam.controller.response.DashboardDto;
import ua.com.alevel.nixjavaexam.controller.response.ProfileDto;
import ua.com.alevel.nixjavaexam.entity.Lesson;
import ua.com.alevel.nixjavaexam.entity.Student;
import ua.com.alevel.nixjavaexam.entity.User;
import ua.com.alevel.nixjavaexam.security.AuthUser;
import ua.com.alevel.nixjavaexam.service.LessonService;
import ua.com.alevel.nixjavaexam.service.UserService;

import java.util.Set;

import static ua.com.alevel.nixjavaexam.entity.Role.STUDENT;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DashboardController {

    private final UserService userService;
    private final LessonService lessonService;

    @GetMapping("/dashboard")
    public DashboardDto dashboard(@AuthenticationPrincipal AuthUser authUser) {
        User user = userService.findByLogin(authUser.getUsername());
        Set<Lesson> lessons = lessonService.findLessonByUser(user);
        return new DashboardDto(user.getLogin(), user.getFirstName(),
                user.getLastName(), user.getEmail(), user.getBirthDate(), lessons);
    }

}
