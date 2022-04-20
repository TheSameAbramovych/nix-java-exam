package ua.com.alevel.nixjavaexam.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.nixjavaexam.entity.Group;
import ua.com.alevel.nixjavaexam.entity.User;
import ua.com.alevel.nixjavaexam.repository.GroupRepository;

@Service
@AllArgsConstructor
public class GroupService {
    private GroupRepository groupRepository;
    public Group findByClassTeacher(User user){
        return groupRepository.findByCurator(user);
    }
}
