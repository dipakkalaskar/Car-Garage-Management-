package org.car.model;

public class ServicingModel {
	  private int servicingID;
	    private int vehicleID;
	    private java.sql.Date serviceDate;
	    private int serviceID;
	    private double totalPrice;

	    // Constructor with all fields
	    public ServicingModel (int servicingID, int vehicleID, java.sql.Date serviceDate, int serviceID, double totalPrice) {
	        this.servicingID = servicingID;
	        this.vehicleID = vehicleID;
	        this.serviceDate = serviceDate;
	        this.serviceID = serviceID;
	        this.totalPrice = totalPrice;
	    }

	    // Default constructor
	    public ServicingModel() {}

	    // Getters and Setters
	    public int getServicingID() {
	        return servicingID;
	    }

	    public void setServicingID(int servicingID) {
	        this.servicingID = servicingID;
	    }

	    public int getVehicleID() {
	        return vehicleID;
	    }

	    public void setVehicleID(int vehicleID) {
	        this.vehicleID = vehicleID;
	    }

	    public java.sql.Date getServiceDate() {
	        return serviceDate;
	    }

	    public void setServiceDate(java.sql.Date serviceDate) {
	        this.serviceDate = serviceDate;
	    }

	    public int getServiceID() {
	        return serviceID;
	    }

	    public void setServiceID(int serviceID) {
	        this.serviceID = serviceID;
	    }

	    public double getTotalPrice() {
	        return totalPrice;
	    }

	    public void setTotalPrice(double totalPrice) {
	        this.totalPrice = totalPrice;
	    }

	    @Override
	    public String toString() {
	        return "Servicing{" +
	                "servicingID=" + servicingID +
	                ", vehicleID=" + vehicleID +
	                ", serviceDate=" + serviceDate +
	                ", serviceID=" + serviceID +
	                ", totalPrice=" + totalPrice +
	                '}';
	    }
	

}
