package com.example.l9_10.Components;

public class Subject {
    private int group;
    private int ID;
    private String name;
    private int course;

    public Subject(int group,int ID, String name, int course) {
        this.group = group;
        this.ID = ID;
        this.name = name;
        this.course = course;
    }

    public int getGroup() {
        return group;
    }


    public int getAuditorium() {
        return ID;
    }


    public String getSubject() {
        return name;
    }

    public int getTeacher() {
        return course;
    }



}
