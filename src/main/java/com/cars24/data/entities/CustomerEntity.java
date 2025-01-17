package com.cars24.data.entities;

//it is a class that represents the table
public class CustomerEntity {
    private int customer_id;
    private String name;
    private String phone;
    private String email;
    private String address;

    public CustomerEntity(int customer_id, String name, String phone, String email, String address) {
        this.customer_id = customer_id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

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
}
