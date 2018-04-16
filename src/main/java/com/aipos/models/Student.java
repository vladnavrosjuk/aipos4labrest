package com.aipos.models;

public class Student {
    private String name;
    private String surname;
    private Univer univer;
    private String group;
    private String avscore;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Univer getUniver() {
        return univer;
    }

    public void setUniver(Univer univer) {
        this.univer = univer;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAvscore() {
        return avscore;
    }

    public void setAvscore(String avscore) {
        this.avscore = avscore;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
