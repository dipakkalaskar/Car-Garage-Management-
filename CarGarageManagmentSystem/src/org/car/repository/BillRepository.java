package org.car.repository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.car.config.DbHelper;
import org.car.dbquery.DbQueries;
import org.car.model.BillModel;
import org.car.model.CustomerModel;
import org.car.model.ServiceModel;

public class BillRepository extends DbHelper {
	private List<BillModel> list = new ArrayList<BillModel>();
	public double getTotalServicingBill(int id) throws SQLException {
		stmt=conn.prepareStatement(DbQueries.GET_SERVICING_PRICE_STRING);
		 stmt.setInt(1, id);
		 rs=stmt.executeQuery();
		
		 
		 if (rs.next()) {
            return rs.getDouble("TotalPrice");
        } else {
            throw new SQLException("Servicing not found for id: " + id);
        }
	}
	public double getAccesoryPrice(int id) throws SQLException {
		stmt=conn.prepareStatement(DbQueries.GET_ACCESSORY_PRICE_STRING);
		 stmt.setInt(1, id);
		 rs=stmt.executeQuery();
		
		 
		 if (rs.next()) {
            return rs.getDouble("Price");
        } else {
            throw new SQLException("Accessory not found for id: " + id);
        }
	}
	public int getVehicleId(int sid) throws SQLException {
		
		stmt=conn.prepareStatement(DbQueries.GET_VEHICLEID_STRING);
		 stmt.setInt(1, sid);
		 rs=stmt.executeQuery();
		
		 
		 if (rs.next()) {
           return rs.getInt("VehicleID");
       } else {
           throw new SQLException("VEHICLE id not found for id: " + sid);
       }
		
	}
public int getCustomerId(int sid) throws SQLException {
		
		stmt=conn.prepareStatement(DbQueries.GET_CUSTID_STRING);
		 stmt.setInt(1, sid);
		 rs=stmt.executeQuery();
		
		 
		 if (rs.next()) {
           return rs.getInt("CustomerID");
       } else {
           throw new SQLException("Customer Id not found for id: " + sid);
       }
		
	}

public int getTotalVisits(int sid) throws SQLException {
	
	stmt=conn.prepareStatement(DbQueries.GET_TOTAL_VISITS_STRING);
	 stmt.setInt(1, sid);
	 rs=stmt.executeQuery();
	
	 
	 if (rs.next()) {
      return rs.getInt("TotalVisits");
  } else {
      throw new SQLException("Customer Id not found for id: " + sid);
  }
	
}
public boolean isGenerateBill(BillModel model) throws SQLException {
	boolean b = false;
//	try {
	if (conn == null) {
		System.out.println("Failed");

	}
	stmt = conn.prepareStatement(DbQueries.ADD_BILL);
	stmt.setInt(1, model.getServicingID());
	stmt.setDate(2, (Date) model.getBillDate());
	stmt.setDouble(3, model.getTotalAmount());
	stmt.setDouble(4, model.getDiscountApplied());
	stmt.setDouble(5, model.getFinalAmount());
	int value = stmt.executeUpdate();

//		System.out.println(value);
	if (value > 0) {
		b = true;
	} else {
		b = false;
	}

	return b;

}

public List<BillModel> getBill(int id) {
	try {
		stmt=conn.prepareStatement(DbQueries.VIEW_BILL_STRING);
		stmt.setInt(1, id);
		rs=stmt.executeQuery();
		
		if (rs.next()) {
			BillModel model = new BillModel();
			model.setBillID(rs.getInt(1));
			model.setServicingID(rs.getInt(2));
			model.setBillDate(rs.getDate(3));
			model.setTotalAmount(rs.getDouble(4));
			model.setDiscountApplied(rs.getDouble(5));
			model.setFinalAmount(rs.getDouble(6));
			list.add(model);
			
		}
		return list.size()>0?list:null;
	
		
	} catch (Exception e) {
		return null;
	}
//	return null;
	
}


}
	



