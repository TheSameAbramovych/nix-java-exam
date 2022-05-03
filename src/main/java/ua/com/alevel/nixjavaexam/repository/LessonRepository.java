package ua.com.alevel.nixjavaexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.nixjavaexam.entity.Group;
import ua.com.alevel.nixjavaexam.entity.Lesson;
import ua.com.alevel.nixjavaexam.entity.User;

import java.util.Set;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    Set<Lesson> findLessonByTeacher(User user);

    Set<Lesson> findLessonByGroup(Group group);
}

