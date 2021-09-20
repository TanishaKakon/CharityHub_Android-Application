package com.example.charityhub;

public class Donor {

    private String FirstName;
    private String LastName;
    private String Phone;

    public Donor(String firstName, String lastName, String phone, String userDonor) {
        FirstName = firstName;
        LastName = lastName;
        Phone = phone;
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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

}
