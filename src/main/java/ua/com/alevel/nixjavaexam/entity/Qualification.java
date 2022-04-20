package ua.com.alevel.nixjavaexam.entity;

public enum Qualification {
    MASTER,NOOB,SENSEI,ZAM,DIRECTOR;
    public String getName(){
        return "Qualification_" + name();
    }
}
