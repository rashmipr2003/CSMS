package com.cars24.data.entities;

import java.time.LocalDateTime;

public class AppointmentsEntity {
    private int appointmentId;
    private int customerId;
    private int vehicleId;
    private int serviceId;
    private LocalDateTime appointmentDate;
    private String status;


    public AppointmentsEntity(int appointmentId, int customerId, int vehicleId, int serviceId, LocalDateTime appointmentDate, String status) {
        this.appointmentId = appointmentId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.serviceId = serviceId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
