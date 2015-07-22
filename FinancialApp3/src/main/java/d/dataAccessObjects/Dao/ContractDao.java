package d.dataAccessObjects.Dao;

import java.sql.SQLException;
import java.util.List;

import b.dataTransferObjects.Contract;

public interface ContractDao {

	List<Contract> getContractByUsername(String username) throws SQLException;

	Contract getContractByVehicleId(int vehicleId) throws SQLException;

}
