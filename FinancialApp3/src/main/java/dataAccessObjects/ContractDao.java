package dataAccessObjects;

import java.sql.SQLException;
import java.util.List;

import dataTransferObjects.Contract;

public interface ContractDao {

	List<Contract> getContractByUsername(String username)  throws SQLException;
	
}
