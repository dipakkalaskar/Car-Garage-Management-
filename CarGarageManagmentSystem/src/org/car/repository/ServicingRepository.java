package org.car.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.car.config.DbHelper;
import org.car.dbquery.DbQueries;
import org.car.model.ServiceModel;
import org.car.model.ServicingModel;

public class ServicingRepository extends DbHelper {
	private List<ServicingModel> list = new ArrayList<ServicingModel>();
	public boolean isAddServicing(ServicingModel model) throws SQLException {
		boolean b = false;
//		try {
		if (conn == null) {
			System.out.println("Failed");

		}
		stmt = conn.prepareStatement("insert into servicing values('0',?,?,?,?)");
		stmt.setInt(1, model.getVehicleID());
		stmt.setDate(2, model.getServiceDate());
		stmt.setInt(3, model.getServiceID());
		
		stmt.setDouble(4, model.getTotalPrice());
		int value = stmt.executeUpdate();

//			System.out.println(value);
		if (value > 0) {
			b = true;
		} else {
			b = false;
		}

		return b;

	}
	 public List<ServicingModel> getAllServices() {
		 try {
				stmt = conn.prepareStatement("select * from servicing");
				rs = stmt.executeQuery();
				while (rs.next()) {
					ServicingModel model = new ServicingModel();
					model.setServicingID(rs.getInt(1));
					model.setVehicleID(rs.getInt(2));
					model.setServiceDate(rs.getDate(3));
					model.setServiceID(rs.getInt(4));
					model.setTotalPrice(rs.getDouble(5));

					list.add(model);

				}
				return list.size() > 0 ? list : null;

			} catch (Exception e) {
				// TODO: handle exception
			}
			return list;
	    }
	 public double GetServicePrice(int id) throws SQLException {
		 stmt=conn.prepareStatement(DbQueries.GET_SERVICE_PRICE_STRING);
		 stmt.setInt(1, id);
		 rs=stmt.executeQuery();
		
		 
		 if (rs.next()) {
             return rs.getDouble("baseprice");
         } else {
             throw new SQLException("Service not found for id: " + id);
         }
     
		 

		 
	 }

}
