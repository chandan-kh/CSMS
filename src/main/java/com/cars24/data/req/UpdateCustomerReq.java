package com.cars24.data.req;

public class UpdateCustomerReq {
    private String name;
    private String phone;
    private String email;
    private String address;
    private String CurrPhone;
    private String CurrEmail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurrPhone() {
        return CurrPhone;
    }

    public void setCurrPhone(String currPhone) {
        CurrPhone = currPhone;
    }

    public String getCurrEmail() {
        return CurrEmail;
    }

    public void setCurrEmail(String currEmail) {
        CurrEmail = currEmail;
    }
}
