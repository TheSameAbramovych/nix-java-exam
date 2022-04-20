package ua.com.alevel.nixjavaexam.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.alevel.nixjavaexam.entity.Teacher;
import ua.com.alevel.nixjavaexam.repository.LessonRepository;
import ua.com.alevel.nixjavaexam.repository.TeacherRepository;
import ua.com.alevel.nixjavaexam.repository.UserRepository;

@Service
public class TeacherService extends UserService {
    TeacherRepository teacherRepository;

    public TeacherService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        super(passwordEncoder, userRepository);
    }

    public void createTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    public Teacher findByLastName(String lastName) {
        return teacherRepository.findTeacherByLastName(lastName);
    }

}
