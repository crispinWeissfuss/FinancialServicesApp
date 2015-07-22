package c.internalServices;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import b.dataTransferObjects.Contract;
import b.dataTransferObjects.ContractService;
import b.dataTransferObjects.User;
import b.dataTransferObjects.Vehicle;
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

		} else { // passwords are not matching 
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

	@Override
	public Contract getCountryServiceProposal(String countryId, int vehicleId, String startDate, String endDate) throws SQLException, ParseException {
		Contract contract = dbAccessLayer.getContractByVehicleId(vehicleId);
		Vehicle vehicle = dbAccessLayer.getVehicleById(vehicleId);

		contract.setVehicle(vehicle);

		contract.setNewRate(this.calculateNewRate(contract.getLeasingRate()));
		contractServices.generateContractName(contract);

		contract.addContractService(this.mockContractServices(countryId, vehicleId, startDate, endDate));

		return contract;
	}

	private double calculateNewRate(double oldRate) {
		double newRate = oldRate + 10;
		Random rand = new Random();
		return newRate + rand.nextInt(25) + 1;
	}

	private ContractService mockContractServices(String countryId, int vehicleId, String startDate, String endDate) throws ParseException {

		ContractService contractService = new ContractService();
		contractService.setDescription("Haftpflicht fuer " + countryId);
		contractServices.generateContractServiceName(contractService);

		Date startDateAsDate = new SimpleDateFormat("dd.MM.yyyy").parse(startDate);
		Date endDateAsDate = new SimpleDateFormat("dd.MM.yyyy").parse(endDate);
		contractService.setStartTimestamp(startDateAsDate);
		contractService.setEndTimestamp(endDateAsDate);
		contractService.setProposal(true);

		return contractService;

	}

}
