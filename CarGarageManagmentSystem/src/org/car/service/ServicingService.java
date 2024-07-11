package org.car.service;

import java.sql.SQLException;
import java.util.List;

import org.car.model.ServiceModel;
import org.car.model.ServicingModel;
import org.car.repository.ServicingRepository;

public class ServicingService {
	ServicingRepository servicingRepository=new ServicingRepository();
	public boolean isAddServicing(ServicingModel model) throws SQLException {

		return servicingRepository.isAddServicing(model);
		
	}
	public List<ServicingModel> GetAllServices(){

		return servicingRepository.getAllServices();
		
	}
	public double getServicePrice(int id) throws SQLException {
		return servicingRepository.GetServicePrice(id);
	}
	
}
