package c.internalServices;

import java.sql.SQLException;
import java.util.List;

import b.dataTransferObjects.Contract;
import b.dataTransferObjects.User;
import d.dataAccessObjects.accesslayer.DbAccessLayer;
import d.dataAccessObjects.accesslayer.DbAccessLayerCassandra;

public class ServicesImpl implements Services {

	private DbAccessLayer dbAccessLayer = null;
	private ContractServices contractServices = null;

	public ServicesImpl() throws ClassNotFoundException, SQLException {
		this.dbAccessLayer = new DbAccessLayerCassandra();
		this.contractServices = new ContractServicesImpl(this.dbAccessLayer);

	}

	@Override
	public User authentificateUser(String username, String password) throws ClassNotFoundException, SQLException {

		User user = dbAccessLayer.authenticateUser(username);

		if (this.checkPassword(password, user.getPassword())) {

			List<Contract> listContracts = this.contractServices.getContractsByUsername(username);
			user.setListOfContracts(listContracts);

		} else { // passwords are not matching --> return empty user
			return null;
		}

		return user;
	}

	private boolean checkPassword(String enteredPassword, String dbPassword) {

		if (enteredPassword.equals(dbPassword)) {
			return true;
		}
		return false;

	}

}
