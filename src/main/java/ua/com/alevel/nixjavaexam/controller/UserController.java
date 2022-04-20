package ua.com.alevel.nixjavaexam.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.nixjavaexam.controller.response.UserResponseDto;
import ua.com.alevel.nixjavaexam.entity.Group;
import ua.com.alevel.nixjavaexam.entity.User;
import ua.com.alevel.nixjavaexam.security.AuthUser;
import ua.com.alevel.nixjavaexam.service.GroupService;
import ua.com.alevel.nixjavaexam.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final GroupService groupService;

    @GetMapping("/user")
    public UserResponseDto user(@AuthenticationPrincipal AuthUser user) {
        return new UserResponseDto(userService.findByLogin(user.getUsername()).getLogin());
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }


    @PostMapping("/lesson")
    public void setLessons(@AuthenticationPrincipal AuthUser authUser) {
        Group group = groupService.findByClassTeacher(userService.findByLogin(authUser.getUsername()));
        System.out.println(group);
//        group.setLesson(lesson);
    }
}
