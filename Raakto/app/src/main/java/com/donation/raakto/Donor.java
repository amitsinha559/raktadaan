package com.donation.raakto;

/**
 * Created by Suvashis on 4/9/2015.
 */
public class Donor {
    private String name;
    private String email;
    private int phoneNumber;
    private int age;
    private String bloodGroup;
    private String password;
    private String confirmPassword;
    private String address;
    private String country;
    private String state;
    private String city;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public int getPhoneNumber(){
        return this.phoneNumber;
    }

    public int getAge() {
        return this.age;
    }

    public String getBloodGroup(){
        return this.bloodGroup;
    }

    public String getPassword() {
        return this.password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCountry() {
        return this.country;
    }

    public String getState() {
        return this.state;
    }

    public String getCity(){
        return this.city;
    }
}
