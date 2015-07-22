package services;

import java.sql.SQLException;
import java.util.List;

import dataAccessObjects.accesslayer.DbAccessLayer;
import dataAccessObjects.accesslayer.DbAccessLayerCassandra;
import dataTransferObjects.Contract;
import dataTransferObjects.ContractService;
import dataTransferObjects.User;

public class ServicesImpl implements Services {

	DbAccessLayer dbAccessLayer = null;;

	public ServicesImpl() throws ClassNotFoundException, SQLException {
		this.dbAccessLayer = new DbAccessLayerCassandra();
	}

	@Override
	public User authentificateUser(String username, String password) throws ClassNotFoundException, SQLException {

		User user = dbAccessLayer.authenticateUser(username);

		if (this.checkPassword(password, user.getPassword())) {

			user.setListOfContracts(this.getContractsByUsername(username));

		} else { // passwords are not matching --> return empty user
			return new User();
		}

		return user;
	}

	private boolean checkPassword(String enteredPassword, String dbPassword) {

		if (enteredPassword.equals(dbPassword)) {
			return true;
		}
		return true; // -->fix it later just for testing !!!

	}

	private List<Contract> getContractsByUsername(String username) throws ClassNotFoundException, SQLException {
		List<Contract> listContracts = dbAccessLayer.getContractsByUser(username);

		for (Contract currContract : listContracts) {
			List<ContractService> listContractServices = this.dbAccessLayer.getServicesByContractId(currContract.getContract_id());
			currContract.setServices(listContractServices);
		}

		return listContracts;

	}

}
