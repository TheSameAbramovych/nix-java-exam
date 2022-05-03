package ua.com.alevel.nixjavaexam.controller.response;

import ua.com.alevel.nixjavaexam.entity.Lesson;

import java.util.Set;

public record DashboardDto(ProfileDto profile, Set<Lesson> lessons) {
}
