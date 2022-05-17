package ua.com.alevel.nixjavaexam.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.nixjavaexam.entity.Lesson;
import ua.com.alevel.nixjavaexam.entity.Student;
import ua.com.alevel.nixjavaexam.entity.User;
import ua.com.alevel.nixjavaexam.repository.LessonRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

@Service
@AllArgsConstructor
public class LessonService {

    private LessonRepository lessonRepository;

    public Set<Lesson> findLessonByTeacher(User user, TimeZone timezone) {
        Date from = Date.from(LocalDate.now().atStartOfDay(ZoneId.of(timezone.getID())).toInstant());
        Date to = Date.from(LocalDate.now().atStartOfDay(ZoneId.of(timezone.getID())).toInstant().plus(1, ChronoUnit.DAYS));

        return lessonRepository.findLessonByTeacherAndTimeBetween(user, from, to);
    }

    public Set<Lesson> findLessonByStudent(Student user, TimeZone timezone) {
        Date from = Date.from(LocalDate.now(timezone.toZoneId()).atStartOfDay(ZoneId.of(timezone.getID())).toInstant());
        Date to = Date.from(LocalDate.now(timezone.toZoneId()).atStartOfDay(ZoneId.of(timezone.getID())).toInstant().plus(1, ChronoUnit.DAYS));

        return lessonRepository.findLessonByGroupAndTimeBetween(user.getGroup(), from, to);
    }
}
