package com.example.shimaashokry.alegny.Domain;

import java.io.Serializable;

/**
 * Created by tasneem on 06/05/2017.
 */

public class Device implements Serializable {
    String DeviceName;
    String DeviceDescription;

    public Device() {
    }

    public Device(String deviceName, String deviceDescription) {
        DeviceName = deviceName;
        DeviceDescription = deviceDescription;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String deviceName) {
        DeviceName = deviceName;
    }

    public String getDeviceDescription() {
        return DeviceDescription;
    }

    public void setDeviceDescription(String deviceDescription) {
        DeviceDescription = deviceDescription;
    }
}

