package dataAccessObjects.accesslayer;

import java.sql.SQLException;
import java.util.List;

import dataTransferObjects.Contract;
import dataTransferObjects.User;

public interface DbAccessLayer {

	User authenticateUser(String username) throws ClassNotFoundException, SQLException;

	List<Contract> getContractsByUser(String username);

}
