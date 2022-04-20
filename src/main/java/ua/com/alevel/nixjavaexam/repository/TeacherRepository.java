package ua.com.alevel.nixjavaexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.nixjavaexam.entity.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findTeacherByLastName(String lastName);
}

