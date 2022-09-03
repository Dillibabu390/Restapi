package com.api.task.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(unique = true)
    private String Email;
    private String FirstName;
    private String LastName;
    private Date Birthday;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Email='" + Email + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Birthday=" + Birthday +
                ", IsActive=" + IsActive +
                ", IsDeleted=" + IsDeleted +
                '}';
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }

    public boolean isDeleted() {
        return IsDeleted;
    }

    public void setDeleted(boolean deleted) {
        IsDeleted = deleted;
    }

    public Student(int id, String email, String firstName, String lastName, Date birthday, boolean isActive, boolean isDeleted) {
        Id = id;
        Email = email;
        FirstName = firstName;
        LastName = lastName;
        Birthday = birthday;
        IsActive = isActive;
        IsDeleted = isDeleted;
    }

    private  boolean IsActive = true;
    private boolean IsDeleted =false;

    public Student() {
    }



}
