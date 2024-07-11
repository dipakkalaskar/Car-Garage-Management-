package org.car.model;

import java.math.BigDecimal;

public class ServiceModel {
	
	    private int serviceID;
	    private String serviceName;
	    private String serviceDescription;
	    private double basePrice;

	    // Constructor with all fields
	    public ServiceModel(int serviceID, String serviceName, String serviceDescription, double basePrice) {
	        this.serviceID = serviceID;
	        this.serviceName = serviceName;
	        this.serviceDescription = serviceDescription;
	        this.basePrice = basePrice;
	    }

	    // Default constructor
	    public ServiceModel() {}

	    // Getters and Setters
	    public int getServiceID() {
	        return serviceID;
	    }

	    public void setServiceID(int serviceID) {
	        this.serviceID = serviceID;
	    }

	    public String getServiceName() {
	        return serviceName;
	    }

	    public void setServiceName(String serviceName) {
	        this.serviceName = serviceName;
	    }

	    public String getServiceDescription() {
	        return serviceDescription;
	    }

	    public void setServiceDescription(String serviceDescription) {
	        this.serviceDescription = serviceDescription;
	    }

	    public double getBasePrice() {
	        return basePrice;
	    }

	    public void setBasePrice(double d) {
	        this.basePrice = d;
	    }

	    @Override
	    public String toString() {
	        return "Service{" +
	                "serviceID=" + serviceID +
	                ", serviceName='" + serviceName + '\'' +
	                ", serviceDescription='" + serviceDescription + '\'' +
	                ", basePrice=" + basePrice +
	                '}';
	    }
	


}
