package com.example.kursov23.models;

import javax.persistence.*;

@Entity
@Table(name = "stugroup")
public class Stugroup {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "group_name")
    private String group_name;

    public Stugroup() {
    }

    public Stugroup(String group_name) {
        this.group_name = group_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    @Override
    public String toString() {
        return "Stugroup{" +
                "id=" + id +
                ", group_name='" + group_name + '\'' +
                '}';
    }
}
