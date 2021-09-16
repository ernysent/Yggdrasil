package com.github.ernysent.yggdrasil.domain;

import java.time.LocalDate;

public class Worker {
    private int id;
    private String firstName;
    private String lastName;
    private String position;
    private Boolean active;
    private String phoneNumber;

    public Worker(){

    }

    public Worker(int id, String firstName, String lastName, String position,
                  String phoneNumber){
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.active = true;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getPosition(){
        return position;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public Boolean getActive(){
        return active;
    }
    public void setActive(Boolean active){
        this.active = active;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public  void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

}

