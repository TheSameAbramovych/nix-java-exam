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

    public Set<Lesson> findLessonByTeacher(User user) {
        return lessonRepository.findLessonByTeacher(user);
    }

    public Set<Lesson> findLessonByStudent(Student user) {
        return lessonRepository.findLessonByGroup(user.getGroup());
    }
}
