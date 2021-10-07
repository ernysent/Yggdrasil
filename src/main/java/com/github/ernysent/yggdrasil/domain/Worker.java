package com.github.ernysent.yggdrasil.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private Boolean active;
    private String phoneNumber;

    public Worker(){

    }

    public Worker(String firstName, String lastName, String position,
                  String phoneNumber){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.active = false;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id){
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

    @Override
    public boolean equals(Object other) {
        if (id == null) {
            return super.equals(other);
        }

        return this == other || other instanceof Worker && id.equals(((Worker) other).id);
    }

    @Override
    public int hashCode(){
        StringBuilder builder = new StringBuilder();
        builder.append(id);
        return builder.toString().hashCode();
    }

}

