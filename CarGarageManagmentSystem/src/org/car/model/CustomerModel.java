package org.car.model;

public class CustomerModel {
	  private int customerID;
	    private String name;
	    private String address;
	    private String phone;
	    private String email;
	    private int totalVisits;

	    // Constructor
	    public CustomerModel() {}

	    public CustomerModel(int customerID, String name, String address, String phone, String email, int totalVisits) {
	        this.customerID = customerID;
	        this.name = name;
	        this.address = address;
	        this.phone = phone;
	        this.email = email;
	        this.totalVisits = totalVisits;
	    }

	    // Getters and Setters
	    public int getCustomerID() {
	        return customerID;
	    }

	    public void setCustomerID(int customerID) {
	        this.customerID = customerID;
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

	    public int getTotalVisits() {
	        return totalVisits;
	    }

	    public void setTotalVisits(int totalVisits) {
	        this.totalVisits = totalVisits;
	    }

	    // toString method for easy printing
	    @Override
	    public String toString() {
	        return "Customer{" +
	                "customerID=" + customerID +
	                ", name='" + name + '\'' +
	                ", address='" + address + '\'' +
	                ", phone='" + phone + '\'' +
	                ", email='" + email + '\'' +
	                ", totalVisits=" + totalVisits +
	                '}';
	    }

}
