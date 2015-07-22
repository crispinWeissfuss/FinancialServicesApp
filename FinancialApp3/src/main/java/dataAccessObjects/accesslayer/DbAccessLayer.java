package dataAccessObjects.accesslayer;

import java.sql.SQLException;
import java.util.List;

import dataTransferObjects.Contract;
import dataTransferObjects.ContractService;
import dataTransferObjects.User;

public interface DbAccessLayer {

	User authenticateUser(String username) throws SQLException;

	List<Contract> getContractsByUser(String username) throws SQLException;

	List<ContractService> getServicesByContractId(int contractId) throws SQLException;

}
