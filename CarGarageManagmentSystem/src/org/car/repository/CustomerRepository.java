package org.car.repository;
import org.car.dbquery.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.car.config.DbConfig;
import org.car.config.DbHelper;
import org.car.model.CustomerModel;

public class CustomerRepository extends DbHelper {
	private List<CustomerModel> list = new ArrayList<CustomerModel>();
	
	public boolean isAddCustomer(CustomerModel model) throws SQLException {
		boolean b = false;
//		try {
		if (conn==null) {
			System.out.println("Failed");
			
		}
			stmt = conn.prepareStatement(DbQueries.ADD_CUSTOMER);
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getAddress());
			stmt.setString(3, model.getPhone());
			stmt.setString(4, model.getEmail());
			stmt.setInt(5, model.getTotalVisits());
			int value=stmt.executeUpdate();
			
//			System.out.println(value);
			if (value>0) {
				b=true;
			}
			else {
				b=false;
			}

		return b;

		
		
		
	}
	
	public List<CustomerModel> getAllCustomers() {
		try {
			stmt=conn.prepareStatement(DbQueries.GET_ALL_CUSTOMERS);
			rs=stmt.executeQuery();
			while (rs.next()) {
				CustomerModel model = new CustomerModel();
				model.setCustomerID(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setAddress(rs.getString(3));
				model.setPhone(rs.getString(4));
				model.setEmail(rs.getString(5));
				model.setTotalVisits(rs.getInt(6));
				list.add(model);
				
			}
			return list.size()>0?list:null;
		
			
		} catch (Exception e) {
			return null;
		}
//		return null;
		
	}
	public boolean isDeleteCustomer(String name) throws SQLException {
		stmt=conn.prepareStatement(DbQueries.DELETE_CUSTOMER);
		stmt.setString(1, name);
		int val=stmt.executeUpdate();
		
		
		
		return val>0?true:false;
		
	}
	public boolean iscustomerUpdate(int id,String name) throws SQLException {
		stmt=conn.prepareStatement(DbQueries.UPDATE_CUSTOMER_ID);
		stmt.setInt(1, id);
		stmt.setString(2, name);
		int val=stmt.executeUpdate();
		return val>0?true:false;
		
	}
	public boolean iscustomerUpdate(String newName,String name) throws SQLException {
		stmt=conn.prepareStatement(DbQueries.UPDATE_CUSTOMER_NAME);
		stmt.setNString(1, newName);
		stmt.setString(2, name);
		int val=stmt.executeUpdate();
		return val>0?true:false;
		
	}

}
