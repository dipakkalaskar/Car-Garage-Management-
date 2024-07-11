package org.car.model;

public class VehicleModel {
	private int vehicleID;
    private int customerID;
    private String vehicleNumber;
    private String model;
    private String make;
    private int year;

    // Constructor
    public VehicleModel(int vehicleID, int customerID, String vehicleNumber, String model, String make, int year) {
        this.vehicleID = vehicleID;
        this.customerID = customerID;
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.make = make;
        this.year = year;
    }

    // Default Constructor
    public VehicleModel() {
    }

    // Getters and Setters
    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID=" + vehicleID +
                ", customerID=" + customerID +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", year=" + year +
                '}';
    }
}
