package com.github.ernysent.yggdrasil.domain;

import java.time.LocalDate;

public class Worker {
    private int id;
    private String firstName;
    private String lastName;
    private String position;
    private String active;
    private String phoneNumber;

    public Worker(){

    }

    public Worker(int id, String firstName, String lastName,
                  String phoneNumber){
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;

    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
}

