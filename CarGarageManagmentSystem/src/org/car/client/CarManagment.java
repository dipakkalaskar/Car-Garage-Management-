package org.car.client;
import java.sql.Date;
import java.sql.*;

import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.net.ssl.SSLContext;

import org.car.model.BillModel;
import org.car.model.CustomerModel;
import org.car.model.ServiceModel;
import org.car.model.ServicingModel;
import org.car.model.VehicleModel;
import org.car.service.BillService;
import org.car.service.CustomerService;
import org.car.service.ServiceServices;
import org.car.service.ServicingService;
import org.car.service.VehicleService;

public class CarManagment {

	public static void main(String[] args) throws SQLException {
		ServiceModel smodel = new ServiceModel();
		ServiceServices serviceServices = new ServiceServices();
		ServicingModel servicingModel = new ServicingModel();
		ServicingService servicingService=new ServicingService();
		BillService billService = new BillService();
		BillModel billModel = new BillModel();

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		CustomerService cms = new CustomerService();
		while (true) {
			System.out.println("Please Choose\n1.Customer Operations\n2.Veichle Operations\n3.Service Operations\n4.Servicing Operations\n5.Generate Bill\n6.View Bill");
			int operationType = sc.nextInt(); // This should be set based on user input
			int operationAction = 1; // This should be set based on user input within each case

			switch (operationType) {
			case 1: // Customer Operations
				CustomerModel model = new CustomerModel();
				System.out.println("1.Add Customer\n2.View Customer\n3.Update Customer\n4.Delete Customer");
				operationAction = sc.nextInt();
				switch (operationAction) {

				case 1: // Add Customer

					System.out.println("Enter Customer Name");
					sc.nextLine();
					String custName = sc.nextLine();

					System.out.println("Enter Customer Address");
					String address = sc.nextLine();

					System.out.println("Enter Phone Number");
					String phone = sc.next();
					System.out.println("Enter Email");
					String email = sc.next();
					System.out.println("Number Of Visits");
					int totalvisits = sc.nextInt();
//	                    	model.setName(custName);
					model.setName(custName);
					model.setAddress(address);
					model.setEmail(email);
					model.setPhone(phone);
					model.setTotalVisits(totalvisits);

					Boolean b = cms.isAddCustomer(model);
					if (b) {
						System.out.println("Customer Added");

					} else {
						System.out.println("Customer Not Added");
					}

					// Add customer logic here
					break;
				case 2: // View Customer

					List<CustomerModel> ls = cms.GetAllCustomers();

					if (ls != null) {
						ls.forEach(
								(m) -> System.out.println(m.getCustomerID() + "\t" + m.getName() + "\t" + m.getAddress()
										+ "\t" + m.getPhone() + "\t" + m.getEmail() + "\t" + m.getTotalVisits()));
					}

					// View customer logic here
					break;
				case 3: // Update Customer
					// Update customer logic here
					int updint;
					sc.nextLine();
					System.out.println("Enter Customer Name Whom Want To Update");
					String name1 = sc.nextLine();
					System.out
							.println("What Want To Update\n1.Id\n2.Name\n3.Email\n4.Phone\n4.Address\n5.Total Visits");
					updint = sc.nextInt();
					switch (updint) {
					case 1: {
						int id;
						System.out.println("Enter New Id");
						id = sc.nextInt();
						b = cms.isCustomerUpdate(id, name1);
						if (b) {
							System.out.println("Id Updated");

						}
					}
						break;
					case 2:
						String nameString;
						sc.nextLine();
						System.out.println("Enter New Name");
						nameString = sc.nextLine();
						b = cms.isCustomerUpdate(nameString, name1);
						if (b) {
							System.out.println("Name Updated");

						}

						break;

					default:
						throw new IllegalArgumentException("Unexpected value: ");
					}

					break;
				case 4: // Delete Customer
					// Delete customer logic here
					sc.nextLine();
					System.out.println("Enter Customer Name Which Want To Delete");
					name1 = sc.nextLine();
					b = cms.isDeleteCustomer(name1);
					if (b) {
						System.out.println("Customer Deleted Sucessfully...");
					} else {
						System.out.println("Wrong Details");
					}
					break;
				default:
					// Invalid action
					break;
				}
				break;

			case 2: // Vehicle Operations
				VehicleModel vmodel = new VehicleModel();
				VehicleService vs = new VehicleService();
				System.out.println("1.Add Vihicle\n2.View Vihicle\n3.Update Vihicle\n4.Delete Vehicle\n5.Search Vehicle");
				operationAction = sc.nextInt();
				switch (operationAction) {
				case 1: // Add Vehicle
					int vehicleID;
					int customerID;
				    String vehicleNumber;
				    String modelofVehicle;
				    String make;
				    int year;
					System.out.println("Enter Veihicle Model Name");
					sc.nextLine();
					modelofVehicle = sc.nextLine();

					System.out.println("Enter Customer Id");
					customerID = sc.nextInt();

					System.out.println("Enter Make Company");
					make = sc.next();
					sc.nextLine();
					System.out.println("Enter Vehicle Number");
					vehicleNumber = sc.nextLine();
					System.out.println("Year");
					year = sc.nextInt();
//	                    	model.setName(custName);
					vmodel.setCustomerID(customerID);;
					vmodel.setMake(make);
					vmodel.setModel(modelofVehicle);
					vmodel.setVehicleNumber(vehicleNumber);
					vmodel.setYear(year);

					Boolean b = vs.isAddVehicle(vmodel);
					if (b) {
						System.out.println("Vehicle Added");

					} else {
						System.out.println("Vehicle Not Added");
					}

					// Add customer logic here
					break;
					// Add vehicle logic here
					
				case 2: // View Vehicle
					List<VehicleModel> ls = vs.GetAllVehicles();

					if (ls != null) {
						ls.forEach(
								(m) -> System.out.println(m.getVehicleID() + "\t" + m.getCustomerID() + "\t" + m.getVehicleNumber()
										+ "\t" + m.getModel() + "\t" + m.getMake() + "\t" + m.getYear()));
					}
					
					// View vehicle logic here
					break;
				case 3: // Update Vehicle
					// Update vehicle logic here
					 System.out.println("Enter Vehicle ID to Update");
		                int vehicleIdToUpdate = sc.nextInt();
		                sc.nextLine(); // Consume newline

		                System.out.println("What Do You Want To Update\n1.Model\n2.Make\n3.Vehicle Number\n4.Year");
		                int updInt = sc.nextInt();
		                sc.nextLine(); // Consume newline

		                boolean updated = false;
		                switch (updInt) {
		                    case 1:
		                        System.out.println("Enter New Model");
		                        String newModel = sc.nextLine();
//		                        updated = vs.isVehicleUpdateModel(vehicleIdToUpdate, newModel);
		                        break;
		                    case 2:
		                        System.out.println("Enter New Make");
		                        String newMake = sc.nextLine();
//		                        updated = vs.isVehicleUpdateMake(vehicleIdToUpdate, newMake);
		                        break;
		                    case 3:
		                        System.out.println("Enter New Vehicle Number");
		                        String newVehicleNumber = sc.nextLine();
//		                        updated = vs.isVehicleUpdateNumber(vehicleIdToUpdate, newVehicleNumber);
		                        break;
		                    case 4:
		                        System.out.println("Enter New Year");
		                        int newYear = sc.nextInt();
//		                        updated = vs.isVehicleUpdateYear(vehicleIdToUpdate, newYear);
		                        break;
		                    default:
		                        System.out.println("Invalid Option");
		                }

		                if (updated) {
		                    System.out.println("Vehicle Updated");
		                } else {
		                    System.out.println("Vehicle Not Updated");
		                }
		                break;

					
				case 4: // Delete Vehicle
					
					// Delete vehicle logic here
					sc.nextLine();
					System.out.println("Enter Vehicle Id Which Want To Delete");
					int vehicleID1 = sc.nextInt();
					b = vs.isDeleteVehicle(vehicleID1);
					if (b) {
						System.out.println("Customer Deleted Sucessfully...");
					} else {
						System.out.println("Wrong Details");
					}
					break;
				case 5: // Search Vehicle
					// Search vehicle logic here
					System.out.println("Enter Vehicle Id Which Want To Search");
					vehicleID1 = sc.nextInt();
					ls = vs.isVeicleAvialable(vehicleID1);

					if (ls != null) {
						System.out.println("Vehicle Found....");
						ls.forEach(
								(m) -> System.out.println(m.getVehicleID() + "\t" + m.getCustomerID() + "\t" + m.getVehicleNumber()
										+ "\t" + m.getModel() + "\t" + m.getMake() + "\t" + m.getYear()));
					}
					else {
						System.out.println("Vehicle Not Found...");
					}
					break;
				default:
					// Invalid action
					break;
				}
				break;

			case 3: // Service Operations
				System.out.println("1.Add Service\n2.View Services\n3.Update Service\n4.Delete Service");
				operationAction=sc.nextInt();
				switch (operationAction) {
				case 1: // Add Service
					// Add service logic here
					System.out.println("Enter Service ID:");
			        smodel.setServiceID(sc.nextInt());
			        sc.nextLine(); // Consume newline

			        System.out.println("Enter Service Name:");
			        smodel.setServiceName(sc.nextLine());

			        System.out.println("Enter Service Description:");
			        smodel.setServiceDescription(sc.nextLine());

			        System.out.println("Enter Base Price:");
			        smodel.setBasePrice(sc.nextDouble());
			        
			        boolean b=serviceServices.isAddService(smodel);
			        if (b) {
						System.out.println("Service Added");

					} else {
						System.out.println("Service Not Added");
					}
			        
			        
			        
					break;
				case 2: // View Service
					// View service logic here
					List<ServiceModel> ls = serviceServices.GetAllServices();

					if (ls != null) {
						ls.forEach(
								(m) -> System.out.println(m.getServiceID() + "\t" + m.getServiceName() + "\t" + m.getServiceDescription()
										+ "\t" + m.getBasePrice()));
					}
					break;
				case 3: // Update Service
					// Update service logic here
					
					break;
				case 4: // Delete Service
					// Delete service logic here
					sc.nextLine();
					System.out.println("Enter Service Id Which Want To Delete");
					int sid = sc.nextInt();
					b = serviceServices.isDeleteService(sid);
					if (b) {
						System.out.println("Customer Deleted Sucessfully...");
					} else {
						System.out.println("Wrong Details");
					}
					break;
				default:
					// Invalid action
					break;
				}
				break;

			case 4: // Servicing Operations

				System.out.println("1.Add Servicing\n2.View Servicing");
				operationAction=sc.nextInt();
				switch (operationAction) {
				case 1: // Add Servicing
					// Add servicing logic here
					 System.out.print("Enter Servicing ID: ");
				        servicingModel.setServicingID(sc.nextInt());
				        sc.nextLine(); // Consume newline

				        System.out.print("Enter Vehicle ID: ");
				        servicingModel.setVehicleID(sc.nextInt());
				        sc.nextLine(); // Consume newline

				        System.out.print("Enter Service Date (yyyy-mm-dd): ");
				        String dateInput = sc.nextLine();
				        servicingModel.setServiceDate(Date.valueOf(dateInput)); // Use java.sql.Date

				        System.out.print("Enter Service ID: ");
				        int servid=sc.nextInt();
				        servicingModel.setServiceID(servid);
				        sc.nextLine(); // Consume newline

				        System.out.print("Enter Total Price: ");
				        
				        servicingModel.setTotalPrice(servicingService.getServicePrice(servid));
				        
				        boolean b=servicingService.isAddServicing(servicingModel);
				        if (b) {
							System.out.println("Service Added");

						} else {
							System.out.println("Service Not Added");
						}
					break;
				case 2: // View Servicing
					// View servicing logic here
					List<ServicingModel> servicingList = servicingService.GetAllServices();
	                if (servicingList != null) {
	                    servicingList.forEach(
	                            m -> System.out.println(m.getServicingID() + "\t" + m.getVehicleID() + "\t" + m.getServiceDate()
	                                    + "\t" + m.getServiceID() + "\t" + m.getTotalPrice()));
	                }
	                else {
						System.out.println("Error");
					}
	                break;
					
				case 3: // Update Servicing
					// Update servicing logic here
					break;
				case 4: // Delete Servicing
					// Delete servicing logic here
					break;
				default:
					// Invalid action
					break;
				}
				break;

			case 5: // Billing Operations
				// Note: Billing operation does not have sub-actions in the provided description
				// Billing logic here
				double accPrice;
				int accid;
				double accTotalPrice = 0;
				
				System.out.println("Enter Servicing Id");
				int servicingId= sc.nextInt();
				double totalcost=billService.getTotalServicingPrice(servicingId);
				System.out.println("Total Price is"+totalcost);
				System.out.println("Want To Add Accessories\n1.Yes\n2.No Continue");
				int isacc=sc.nextInt();
				if (isacc==1) {
					int quantity;
					System.out.println("Select Accessory Id\n----+--------------------------+--------+\r\n"
							+ "|              1 | Car Air Freshener        |   5.99 |\r\n"
							+ "|              2 | Car Seat Cover           |  49.99 |\r\n"
							+ "|              3 | GPS Navigation System    | 199.99 |\r\n"
							+ "|              4 | Dashboard Camera         |  89.99 |\r\n"
							+ "|              5 | Car Charger              |  14.99 |\r\n"
							+ "|              6 | Trunk Organizer          |  29.99 |\r\n"
							+ "|              7 | Bluetooth FM Transmitter |  19.99 |\r\n"
							+ "|              8 | Steering Wheel Cover     |  15.99 |\r\n"
							+ "|              9 | Floor Mats               |  39.99 |\r\n"
							+ "|             10 | Windshield Sun Shade     |  12.99 |");
					accid=sc.nextInt();
					accPrice=billService.getAccessoryPrice(accid);
					System.out.println("Quantity");
					quantity=sc.nextInt();
					accTotalPrice=accPrice*quantity;
					System.out.println("Accessory Price is"+accTotalPrice);
					
				}
				double totalAmount=totalcost+accTotalPrice;
				billModel.setServicingID(servicingId);
				billModel.setTotalAmount(totalAmount);
				System.out.println("Enter Bill Date");
				sc.nextLine();
				String dateInput = sc.nextLine();
				billModel.setBillDate(Date.valueOf(dateInput));
				int vid=billService.getVehicleId(servicingId);
				int cid=billService.getCustomerId(vid);
				int totalVisits=billService.getTotalVisits(cid);
				double discount=0;
				if (totalVisits==1) {
					discount=totalAmount*0.1;
				}
				else if (totalVisits>=5) {
					discount=totalAmount*0.15;
				}
				else {
					discount=0;
				}
				billModel.setDiscountApplied(discount);
				double FinalAmount=totalAmount-discount;
				billModel.setFinalAmount(FinalAmount);
				boolean b=billService.isGenerateBill(billModel);
				if (b) {
					System.out.println("Bill Generated...");
					
				}
				System.out.println(discount);
				
				break;

			case 6: // Offer and Discount Operations
				System.out.println("Enter Bill ID");
				int billId=sc.nextInt();
				List<BillModel> ls = billService.GetBill(billId);

				if (ls != null) {
					ls.forEach(
							(m) -> System.out.println(m.getBillID() + "\t" + m.getServicingID() +"\t"+m.getBillDate()+ "\t" + m.getTotalAmount()
									+ "\t" + m.getDiscountApplied() +"\t"+m.getFinalAmount()));
				}
				else {
					System.out.println("No Bill Found");
				}
				break;

			case 7: // Report Generation
				switch (operationAction) {
				case 1: // Date-wise Report
					// Generate date-wise report logic here
					break;
				case 2: // Month-wise Report
					// Generate month-wise report logic here
					break;
				case 3: // Quarter-wise Report
					// Generate quarter-wise report logic here
					break;
				case 4: // Year-wise Report
					// Generate year-wise report logic here
					break;
				case 5: // Customer-wise Report
					// Generate customer-wise report logic here
					break;
				default:
					// Invalid action
					break;
				}
				break;
			case 0:
				continue;

			default:
				// Invalid operation type
				break;
			}
		}
	}

}
