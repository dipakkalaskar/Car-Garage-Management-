package org.car.repository;

import java.security.PublicKey;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.car.config.DbHelper;
import org.car.model.CustomerModel;
import org.car.model.VehicleModel;

public class VehicleRepository extends DbHelper {

	private List<VehicleModel> list = new ArrayList<VehicleModel>();

	public boolean isAddVehicle(VehicleModel model) throws SQLException {
		boolean b = false;
//		try {
		if (conn==null) {
			System.out.println("Failed");
			
		}
			stmt = conn.prepareStatement("insert into vehicle values('0',?,?,?,?,?)");
			stmt.setInt(1, model.getCustomerID());
			stmt.setString(2, model.getVehicleNumber());
			stmt.setString(3, model.getModel());
			stmt.setString(4, model.getMake());
			stmt.setInt(5, model.getYear());
			int value=stmt.executeUpdate();
			
//			System.out.println(value);
			if (value>0) {
				b=true;
			}
			else {
				b=false;
			}

		return b;
		// TODO Auto-generated method stub
		
	}
	public List<VehicleModel> getAllVeicle() {
		try {
			stmt=conn.prepareStatement("select * from vehicle");
			rs=stmt.executeQuery();
			while (rs.next()) {
				VehicleModel model = new VehicleModel();
				model.setVehicleID(rs.getInt(1));
				model.setCustomerID(rs.getInt(2));
				model.setVehicleNumber(rs.getString(3));
				model.setModel(rs.getString(4));
				model.setMake(rs.getString(5));
				model.setYear(rs.getInt(6));
				list.add(model);
				
			}
			return list.size()>0?list:null;
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		}
		
		public boolean isDeleteVechile(int id) throws SQLException {
			stmt=conn.prepareStatement("delete from vehicle where vehicleid=?");
			stmt.setInt(1, id);
			int val=stmt.executeUpdate();
			
			return val>0?true:false;
		
	}
		public List<VehicleModel> isVehicleAvialable(int id) {
			try {
				stmt=conn.prepareStatement("select * from vehicle where vehicleid=?");
				stmt.setInt(1, id);
				rs=stmt.executeQuery();
				while (rs.next()) {
					VehicleModel model = new VehicleModel();
					model.setVehicleID(rs.getInt(1));
					model.setCustomerID(rs.getInt(2));
					model.setVehicleNumber(rs.getString(3));
					model.setModel(rs.getString(4));
					model.setMake(rs.getString(5));
					model.setYear(rs.getInt(6));
					list.add(model);
				
					
					
				}
				return list.size()>0?list:null;
			
				
			} catch (Exception e) {
				return null;
			}
//		return null;
	
		}
		
		public boolean isDeleteVehicle(int id) throws SQLException {
			stmt=conn.prepareStatement("delete from vehicle where id=?");
			stmt.setInt(1, id);;
			int val=stmt.executeUpdate();
			
			
			
			return val>0?true:false;
			
		}
		}

