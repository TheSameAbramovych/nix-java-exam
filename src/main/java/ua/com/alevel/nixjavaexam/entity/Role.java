package ua.com.alevel.nixjavaexam.entity;

public enum Role {
    STUDENT,
    TEACHER,
    ADMIN;

    public String getName(){
        return "ROLE_" + name();
    }
}
