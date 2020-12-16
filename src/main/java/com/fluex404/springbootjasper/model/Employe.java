package com.fluex404.springbootjasper.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Employe {
    private Integer id;
    private String name;
    private Integer salary;

    public Employe(Integer id, String name, Integer salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
