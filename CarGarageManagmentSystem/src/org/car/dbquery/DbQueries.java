package org.car.dbquery;

public class DbQueries {
	public static final String ADD_CUSTOMER = "insert into customer values('0',?,?,?,?,?)";
	public static final String GET_ALL_CUSTOMERS = "select * from customer";
	public static final String DELETE_CUSTOMER = "delete from customer where name=?";
	public static final String UPDATE_CUSTOMER_ID = "update customer set id=? where name=?";
	public static final String UPDATE_CUSTOMER_NAME = "update customer set name=? where name=?";
	public static final String ADD_SERVICE = "insert into service values('0',?,?,?)";
	public static final String GET_ALL_SERVICES = "select * from service";
	public static final String DELETE_SERVICE = "delete from service where serviceid=?";
	public static final String GET_SERVICE_PRICE_STRING = "select baseprice from service where serviceid=?";
	public static final String GET_SERVICING_PRICE_STRING = "select TotalPrice from servicing where servicingid=?";
	public static final String GET_ACCESSORY_PRICE_STRING = "select Price from accessories where accessories_id=?";
	public static final String GET_VEHICLEID_STRING = "select VehicleID from servicing where servicingid=?";
	public static final String GET_CUSTID_STRING = "select CustomerID from vehicle where VehicleID=?";
	public static final String GET_TOTAL_VISITS_STRING = "select TotalVisits from CUSTOMER where CustomerID=?";
	public static final String ADD_BILL = "insert into bill values('0',?,?,?,?,?)";
	public static final String VIEW_BILL_STRING ="select * from bill where billid=?";
}
