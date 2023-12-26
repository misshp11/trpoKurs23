package com.example.kursov23.models;

import lombok.Getter;

@Getter
public class StatDTO {
    private Statistics statistics;
    private String pers_name;
    private String surname;
    private String group_name;
    private String subname;

    public StatDTO(Statistics statistics, String pers_name, String surname, String group_name, String subname) {
        this.statistics = statistics;
        this.pers_name = pers_name;
        this.surname = surname;
        this.group_name = group_name;
        this.subname = subname;
    }
}
