package com.example.loginapp_sqlightdb;
import java.util.Date;

public class UserProfile {


    public UserProfile(String first_name, String last_name, String dob, String address, String phone_number, String pass) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.address = address;
        this.phone_number = phone_number;
        this.password = pass;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", phone_number=" + phone_number +
                '}';
    }

    private String first_name;
    private String last_name;
    private String dob;
    private String address;
    private String phone_number;
    private String password;


}
