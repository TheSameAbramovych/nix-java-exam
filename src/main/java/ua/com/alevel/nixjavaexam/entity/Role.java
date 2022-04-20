package ua.com.alevel.nixjavaexam.entity;

public enum Role {
    USER,
    OPERATOR,
    SUPPORT,
    ADMIN;

    public String getName(){
        return "ROLE_" + name();
    }
}
