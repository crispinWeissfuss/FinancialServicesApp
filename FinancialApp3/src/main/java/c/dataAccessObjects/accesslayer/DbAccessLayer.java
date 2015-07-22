package c.dataAccessObjects.accesslayer;

import java.sql.SQLException;
import java.util.List;

import a.dataTransferObjects.Contract;
import a.dataTransferObjects.ContractService;
import a.dataTransferObjects.User;
import a.dataTransferObjects.Vehicle;

public interface DbAccessLayer {

	User authenticateUser(String username) throws SQLException;

	List<Contract> getContractsByUser(String username) throws SQLException;

	List<ContractService> getServicesByContractId(int contractId) throws SQLException;

	String getCountryNameByCountryId(int countryId) throws SQLException;
	
	Vehicle getVehicleById(int VehicleId)  throws SQLException;

}
