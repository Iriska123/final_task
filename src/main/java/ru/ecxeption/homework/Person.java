package ru.ecxeption.homework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    String name;
    String second_name;
    String surname;
    String female;
    String phoneNumber;
    String birthDay;


    public void setName(String name) {
        this.name = name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Person() {

    }

    public Person(String name, String second_name, String surname, String female, String phoneNumber, String birthDay) {
        this.name = name;
        this.second_name = second_name;
        this.surname = surname;
        this.female = female;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public String getFemale() {
        return female;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getSurname() {
        return surname;
    }
}
