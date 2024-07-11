package org.car.model;

import java.util.Date;

public class BillModel {
	private int billID;
    private int servicingID;
    private Date billDate;
    private double totalAmount;
    private double discountApplied;
    private double finalAmount;

    // Default constructor
    public BillModel() {
    }

    // Parameterized constructor
    public BillModel(int billID, int servicingID, Date billDate, double totalAmount, double discountApplied, double finalAmount) {
        this.billID = billID;
        this.servicingID = servicingID;
        this.billDate = billDate;
        this.totalAmount = totalAmount;
        this.discountApplied = discountApplied;
        this.finalAmount = finalAmount;
    }

    // Getters and Setters
    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public int getServicingID() {
        return servicingID;
    }

    public void setServicingID(int servicingID) {
        this.servicingID = servicingID;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(double discountApplied) {
        this.discountApplied = discountApplied;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billID=" + billID +
                ", servicingID=" + servicingID +
                ", billDate=" + billDate +
                ", totalAmount=" + totalAmount +
                ", discountApplied=" + discountApplied +
                ", finalAmount=" + finalAmount +
                '}';
    }

}
