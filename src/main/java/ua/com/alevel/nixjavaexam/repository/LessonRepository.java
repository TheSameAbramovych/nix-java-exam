package ua.com.alevel.nixjavaexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.nixjavaexam.entity.Group;
import ua.com.alevel.nixjavaexam.entity.Lesson;
import ua.com.alevel.nixjavaexam.entity.User;

import java.util.Date;
import java.util.Set;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    Set<Lesson> findLessonByTeacherAndTimeBetween(User user, Date from, Date to);

    Set<Lesson> findLessonByGroupAndTimeBetween(Group group, Date from, Date to);
}

