package com.example.l13.model;

import com.example.l13.db.Identified;

public class Student implements Identified<Integer> {
    private int id;
    private String name;
    private int group;
    private int course;

    public Student() {}

    public Student(String name, int group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
    }

    public Student(int id, String name, int group, int course) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.course = course;
    }

    //region Getter and Setter
    @Override
    public Integer getId() { return id;}

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
    //endregion
}