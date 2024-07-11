package org.car.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.car.config.DbHelper;
import org.car.dbquery.DbQueries;
import org.car.model.CustomerModel;
import org.car.model.ServiceModel;
import org.car.model.VehicleModel;

public class ServiceRepository extends DbHelper {
	private List<ServiceModel> list = new ArrayList<ServiceModel>();

	public boolean isAddService(ServiceModel model) throws SQLException {
		boolean b = false;
//		try {
		if (conn == null) {
			System.out.println("Failed");

		}
		stmt = conn.prepareStatement(DbQueries.ADD_SERVICE);
		stmt.setString(1, model.getServiceName());
		stmt.setString(2, model.getServiceDescription());
		stmt.setDouble(3, model.getBasePrice());
		int value = stmt.executeUpdate();

//			System.out.println(value);
		if (value > 0) {
			b = true;
		} else {
			b = false;
		}

		return b;

	}

	public List<ServiceModel> getAllServices() {
		try {
			stmt = conn.prepareStatement(DbQueries.GET_ALL_SERVICES);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ServiceModel model = new ServiceModel();
				model.setServiceID(rs.getInt(1));
				model.setServiceName(rs.getString(2));
				model.setServiceDescription(rs.getString(3));
				model.setBasePrice(rs.getDouble(4));

				list.add(model);

			}
			return list.size() > 0 ? list : null;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public boolean isDeleteService(int id) throws SQLException {
		stmt = conn.prepareStatement(DbQueries.DELETE_SERVICE);
		stmt.setInt(1, id);
		;
		int val = stmt.executeUpdate();

		return val > 0 ? true : false;

	}

}
