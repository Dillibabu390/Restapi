package com.api.task.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String Email;
    private String Password;
    private String FirstName;
    private String LastName;

    private boolean IsActive = true;
    private boolean IsDeleted = false;

    public User() {
    }


    public User(Integer id, String email, String password, String firstName, String lastName, boolean isActive, boolean isDeleted) {
        this.id = id;
        Email = email;
        Password = password;
        FirstName = firstName;
        LastName = lastName;
        IsActive = isActive;
        IsDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", IsActive=" + IsActive +
                ", IsDeleted=" + IsDeleted +
                '}';
    }
}
