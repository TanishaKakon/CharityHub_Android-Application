package com.example.charityhub;

public class Recipient {

    private  String OrganizationName;
    private  String RegistrationNo;
    private  String WebsiteLink;
    private  String Address;
    private  String BKashNumber;
    private  String AccountNo;

    public Recipient(String organizationName, String registrationNo, String websiteLink, String address, String BKashNumber, String accountNo, String userRecipient, String type) {
        OrganizationName = organizationName;
        RegistrationNo = registrationNo;
        WebsiteLink = websiteLink;
        Address = address;
        this.BKashNumber = this.BKashNumber;
        AccountNo = accountNo;
    }

    public String getOrganizationName() {
        return OrganizationName;
    }

    public void setOrganizationName(String organizationName) {
        OrganizationName = organizationName;
    }

    public String getRegistrationNo() {
        return RegistrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        RegistrationNo = registrationNo;
    }

    public String getWebsiteLink() {
        return WebsiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        WebsiteLink = websiteLink;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBKashNumber() {
        return BKashNumber;
    }

    public void setBKashNumber(String BKashNumber) {
        this.BKashNumber = BKashNumber;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String accountNo) {
        AccountNo = accountNo;
    }
}
