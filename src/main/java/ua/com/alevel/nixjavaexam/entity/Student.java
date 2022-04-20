package ua.com.alevel.nixjavaexam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
public class Student extends User {
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}
