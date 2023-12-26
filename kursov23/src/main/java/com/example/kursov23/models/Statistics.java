package com.example.kursov23.models;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistics {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sum_mark")
    private float sum_mark;

    @Column(name = "id_subject")
    private int id_subject;

    @Column(name = "id_user")
    private int id_user;

    public Statistics() {
    }

    public Statistics(float sum_mark, int id_subject, int id_user) {
        this.sum_mark = sum_mark;
        this.id_subject = id_subject;
        this.id_user = id_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSum_mark() {
        return sum_mark;
    }

    public void setSum_mark(float sum_mark) {
        this.sum_mark = sum_mark;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "id=" + id +
                ", sum_mark=" + sum_mark +
                ", id_subject=" + id_subject +
                ", id_user=" + id_user +
                '}';
    }
}
