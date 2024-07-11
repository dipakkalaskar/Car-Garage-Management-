package org.car.service;

import java.sql.SQLException;
import java.util.List;

import org.car.model.CustomerModel;
import org.car.model.VehicleModel;
import org.car.repository.VehicleRepository;

public class VehicleService {
	VehicleRepository vehicleRepository=new VehicleRepository();
	public boolean isAddVehicle(VehicleModel model) throws SQLException {

		return vehicleRepository.isAddVehicle(model);
		
	}
	public List<VehicleModel> GetAllVehicles(){

		return vehicleRepository.getAllVeicle();
		
	}
	public boolean isDeleteVehicle(int id) throws SQLException {
		return vehicleRepository.isDeleteVechile(id);
		
	}
	public List<VehicleModel> isVeicleAvialable(int id){

		return vehicleRepository.isVehicleAvialable(id);
		
	}
}
