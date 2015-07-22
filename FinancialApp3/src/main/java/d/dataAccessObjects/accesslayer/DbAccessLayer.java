package d.dataAccessObjects.accesslayer;

import java.sql.SQLException;
import java.util.List;

import b.dataTransferObjects.Contract;
import b.dataTransferObjects.ContractService;
import b.dataTransferObjects.User;
import b.dataTransferObjects.Vehicle;

public interface DbAccessLayer {

	User authenticateUser(String username) throws SQLException;

	Contract getContractByVehicleId(int vehicleId) throws SQLException;

	List<Contract> getContractsByUser(String username) throws SQLException;

	List<ContractService> getServicesByContractId(int contractId) throws SQLException;

	String getCountryNameByCountryId(int countryId) throws SQLException;

	Vehicle getVehicleById(int VehicleId) throws SQLException;

}
