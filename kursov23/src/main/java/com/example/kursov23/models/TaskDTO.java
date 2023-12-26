package com.example.kursov23.models;

import lombok.Getter;

@Getter
public class TaskDTO {
    private Tasks tasks;
    private String group_name;
    private String surname;
    private String pers_name;
    private String subname;

    public TaskDTO(Tasks tasks, String group_name, String surname, String pers_name, String subname) {
        this.tasks = tasks;
        this.group_name = group_name;
        this.surname = surname;
        this.pers_name = pers_name;
        this.subname = subname;
    }
}
