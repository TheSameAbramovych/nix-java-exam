package ua.com.alevel.nixjavaexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.alevel.nixjavaexam.entity.Group;
import ua.com.alevel.nixjavaexam.entity.User;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByCurator(User user);
}
