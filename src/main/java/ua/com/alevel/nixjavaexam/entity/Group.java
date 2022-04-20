package ua.com.alevel.nixjavaexam.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "student_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "headman_id")
    @JsonBackReference
    private Student headman;
    @OneToMany(mappedBy = "group")
    @JsonBackReference
    private Set<Student> students;
    private String name;
    @ManyToOne
    @JoinColumn(name = "curator_id")
    private Teacher curator;
}
