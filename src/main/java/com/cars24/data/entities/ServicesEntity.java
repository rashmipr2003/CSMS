package com.cars24.data.entities;

public class ServicesEntity {
    private int serviceId;
    private String serviceName;
    private Double price; // here BigDecimal was suggested but it gives more precision
    //so less performance and it can be used when u have money, financial calculations or high precision
    //requirements


    public ServicesEntity(int serviceId, String serviceName, Double price) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.price = price;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
