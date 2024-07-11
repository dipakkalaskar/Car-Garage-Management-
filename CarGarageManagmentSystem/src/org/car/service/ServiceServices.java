package org.car.service;

import java.sql.SQLException;
import java.util.List;

import org.car.model.ServiceModel;
import org.car.model.VehicleModel;
import org.car.repository.ServiceRepository;

public class ServiceServices {
	ServiceRepository serviceRepository = new ServiceRepository();
	public boolean isAddService(ServiceModel model) throws SQLException {

		return serviceRepository.isAddService(model);
		
	}
	public List<ServiceModel> GetAllServices(){

		return serviceRepository.getAllServices();
		
	}
	public boolean isDeleteService(int id) throws SQLException {
		return serviceRepository.isDeleteService(id);
		
	}

}
