package com.example.shimaashokry.alegny.Domain;

import java.io.Serializable;

/**
 * Created by tasneem on 06/05/2017.
 */

public class Hospital implements Serializable {
    String name, address, website, department[];
    int ticket, phone[];
    Device device[];


    public Hospital(String name, String address, String website, String[] department, int ticket, int[] phone, Device[] device) {
        this.name = name;
        this.address = address;
        this.website = website;
        this.department = department;
        this.ticket = ticket;
        this.phone = phone;
        this.device = device;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String[] getDepartment() {
        return department;
    }

    public void setDepartment(String[] department) {
        this.department = department;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public int[] getPhone() {
        return phone;
    }

    public void setPhone(int[] phone) {
        this.phone = phone;
    }

    public Device[] getDevice() {
        return device;
    }

    public void setDevice(Device[] device) {
        this.device = device;
    }
}
