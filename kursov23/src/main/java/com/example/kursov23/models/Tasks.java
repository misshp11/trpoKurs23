package com.example.kursov23.models;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Tasks {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mark")
    private float mark;

    @Column(name = "id_group")
    private int id_group;

    @Column(name = "id_user")
    private int id_user;

    @Column(name = "task_name")
    private String task_name;

    @Column(name = "id_subject")
    private int id_subject;

    public Tasks() {
    }

    public Tasks(float mark, int id_group, int id_user, String task_name, int id_subject) {
        this.mark = mark;
        this.id_group = id_group;
        this.id_user = id_user;
        this.task_name = task_name;
        this.id_subject = id_subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", mark=" + mark +
                ", id_group=" + id_group +
                ", id_user=" + id_user +
                ", task_name='" + task_name + '\'' +
                ", id_subject=" + id_subject +
                '}';
    }
}
