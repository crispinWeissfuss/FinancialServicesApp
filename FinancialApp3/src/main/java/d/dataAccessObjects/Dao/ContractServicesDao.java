package d.dataAccessObjects.Dao;

import java.sql.SQLException;
import java.util.List;

import b.dataTransferObjects.ContractService;

public interface ContractServicesDao {
	
	List<ContractService> getServicesByContractId(int contractId)  throws SQLException;
	

}
