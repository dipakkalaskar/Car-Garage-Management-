package org.car.service;

import java.sql.SQLException;
import java.util.List;

import org.car.model.BillModel;
import org.car.model.ServiceModel;
import org.car.repository.BillRepository;

public class BillService {
	BillRepository billRepository = new BillRepository();
	public double getTotalServicingPrice(int id) throws SQLException {
		return billRepository.getTotalServicingBill(id);
	}
	public double getAccessoryPrice(int id) throws SQLException {
		return billRepository.getAccesoryPrice(id);
	}
	public int getVehicleId(int sid) throws SQLException {
		return	billRepository.getVehicleId(sid);
	}
	public int getCustomerId(int sid) throws SQLException {
		return	billRepository.getCustomerId(sid);
	}
	public int getTotalVisits(int sid) throws SQLException {
		return	billRepository.getTotalVisits(sid);
	}
	public boolean isGenerateBill(BillModel model) throws SQLException {
		return billRepository.isGenerateBill(model);
	}
	public List<BillModel> GetBill(int id){

		return billRepository.getBill(id);
		
	}

}
