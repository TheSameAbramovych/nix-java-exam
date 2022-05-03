package ua.com.alevel.nixjavaexam.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.nixjavaexam.entity.Lesson;
import ua.com.alevel.nixjavaexam.entity.Student;
import ua.com.alevel.nixjavaexam.entity.User;
import ua.com.alevel.nixjavaexam.repository.LessonRepository;

import java.util.Set;

@Service
@AllArgsConstructor
public class LessonService {
    private LessonRepository lessonRepository;

    public Set<Lesson> findLessonByUser(User user) {
        if (user instanceof Teacher) {
            return lessonRepository.findLessonByTeacher(user);
        } else {
            return null;
        }
    }
}
