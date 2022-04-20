package ua.com.alevel.nixjavaexam.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.alevel.nixjavaexam.repository.UserRepository;

@Service
public class StudentService extends UserService {

    public StudentService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        super(passwordEncoder, userRepository);
    }
}

