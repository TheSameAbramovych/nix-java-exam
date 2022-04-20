package ua.com.alevel.nixjavaexam.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.alevel.nixjavaexam.entity.Role;
import ua.com.alevel.nixjavaexam.entity.User;
import ua.com.alevel.nixjavaexam.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public void saveUser(User user) {
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findByLoginAndPassword(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        throw new UsernameNotFoundException(login);
    }

    public boolean loginIsUnique(String login) {
        return userRepository.existsByLogin(login);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll(Sort.by("login"));
    }
}
