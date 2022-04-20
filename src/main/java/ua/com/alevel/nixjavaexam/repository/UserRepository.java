package ua.com.alevel.nixjavaexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.alevel.nixjavaexam.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    boolean existsByLogin(String login);
}
