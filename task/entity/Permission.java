package com.api.task.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String Code;
    private boolean IsDeleted;
    private String Description;


    public Permission() {
    }

    public Permission(int id, String code, boolean isDeleted, String description) {
        Id = id;
        Code = code;
        IsDeleted = isDeleted;
        Description = description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public boolean isDeleted() {
        return IsDeleted;
    }

    public void setDeleted(boolean deleted) {
        IsDeleted = deleted;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "Id=" + Id +
                ", Code='" + Code + '\'' +
                ", IsDeleted=" + IsDeleted +
                ", Description='" + Description + '\'' +
                '}';
    }
}
