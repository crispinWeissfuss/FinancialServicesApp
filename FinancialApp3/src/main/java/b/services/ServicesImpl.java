package b.services;

import java.sql.SQLException;
import java.util.List;

import a.dataTransferObjects.Contract;
import a.dataTransferObjects.ContractService;
import a.dataTransferObjects.User;
import c.dataAccessObjects.accesslayer.DbAccessLayer;
import c.dataAccessObjects.accesslayer.DbAccessLayerCassandra;

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
		return false;

	}

	private List<Contract> getContractsByUsername(String username) throws ClassNotFoundException, SQLException {
		List<Contract> listContracts = dbAccessLayer.getContractsByUser(username);

		for (Contract currContract : listContracts) {
			this.addContractServicesToContract(currContract);
			this.addVehicleToContract(currContract);
		}

		return listContracts;

	}

	private void addContractServicesToContract(Contract contract) throws SQLException {
		List<ContractService> listContractServices = this.dbAccessLayer.getServicesByContractId(contract.getContract_id());
		this.addCountryNameToContractServices(listContractServices);
		contract.setServices(listContractServices);
	}

	private void addCountryNameToContractServices(List<ContractService> listContractServices) throws SQLException {
		for (ContractService currContractService : listContractServices) {

			String countryName = this.dbAccessLayer.getCountryNameByCountryId(currContractService.getCountry_Id());
			currContractService.setCountryName(countryName);

		}
	}

	private void generateContractName(Contract contract) {
		String contractName = contract.getType() + " -Vertrag ";
	}

	private void addVehicleToContract(Contract contract) throws SQLException {
		contract.setVehicle(this.dbAccessLayer.getVehicleById(contract.getVehicleId()));
	}

}
