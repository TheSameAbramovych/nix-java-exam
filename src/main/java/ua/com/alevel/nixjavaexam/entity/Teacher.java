package ua.com.alevel.nixjavaexam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
public class Teacher extends User {
    @Enumerated(EnumType.STRING)
    private Qualification qualification;
}
