package c.dataAccessObjects.Dao;

import java.sql.SQLException;
import java.util.List;

import a.dataTransferObjects.Contract;

public interface ContractDao {

	List<Contract> getContractByUsername(String username)  throws SQLException;
	
}
