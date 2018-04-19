package com.company.Users;


import java.sql.Date;
import java.util.ArrayList;

public class Employee extends Person {
    private int incomeGenerated;
    private Date holiday;
    private ArrayList<String> skills;


    public Employee(String name, String surname, String phone) {
        super(name, surname, phone);
    }

    public String addSkill(String newSkill){
        skills.add(newSkill);
        return null;
    }


    public int getIncomeGenerated() {
        return incomeGenerated;
    }

    public void setIncomeGenerated(int incomeGenerated) {
        this.incomeGenerated += incomeGenerated;
    }

    public Date getHoliday() {
        return holiday;
    }

    public void setHoliday(Date holiday) {
        this.holiday = holiday;
    }



}
