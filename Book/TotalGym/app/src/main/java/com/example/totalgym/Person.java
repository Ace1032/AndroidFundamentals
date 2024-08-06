package com.example.totalgym;

public class Person {
    private String p_f_name;
    private String p_l_name;
    private int p_age;
    private String med_risk;
    private String health_goal;
    private double bmi_score;
    private boolean gender_M;
    private int height;
    private int weight;


    public Person(String pFName, String pLName, int pAge) {
        p_f_name = pFName;
        p_l_name = pLName;
        p_age = pAge;
    }

    public String getMed_risk() {
        return med_risk;
    }

    public void setMed_risk(String med_risk) {
        this.med_risk = med_risk;
    }

    public String getHealth_goal() {
        return health_goal;
    }

    public void setHealth_goal(String health_goal) {
        this.health_goal = health_goal;
    }

    public double getBmi_score() {
        return bmi_score;
    }

    public void setBmi_score(double bmi_score) {
        this.bmi_score = bmi_score;
    }

    public boolean isGender_M() {
        return gender_M;
    }

    public void setGender_M(boolean gender_M) {
        this.gender_M = gender_M;
    }
}
