package d.dataAccessObjects.accesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import b.dataTransferObjects.Contract;
import b.dataTransferObjects.ContractService;
import b.dataTransferObjects.User;
import b.dataTransferObjects.Vehicle;
import d.dataAccessObjects.CassandraDao.ContractCassandraDao;
import d.dataAccessObjects.CassandraDao.ContractServiceCassandraDao;
import d.dataAccessObjects.CassandraDao.CountryCassandraDao;
import d.dataAccessObjects.CassandraDao.UserDaoCassandra;
import d.dataAccessObjects.CassandraDao.VehicleCassandraDao;
import d.dataAccessObjects.Dao.ContractDao;
import d.dataAccessObjects.Dao.ContractServicesDao;
import d.dataAccessObjects.Dao.CountryDao;
import d.dataAccessObjects.Dao.UserDao;
import d.dataAccessObjects.Dao.VehicleDao;

public class DbAccessLayerCassandra implements DbAccessLayer {

	private Connection con = null;
	private UserDao userDao = null;
	private ContractDao contractDao = null;
	private ContractServicesDao contractServices = null;
	private CountryDao countryDao = null;
	private VehicleDao vehicleDao = null;

	public DbAccessLayerCassandra() throws ClassNotFoundException, SQLException {
		Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
		this.con = DriverManager.getConnection("jdbc:cassandra:http://10.255.1.206:32769");

		this.userDao = new UserDaoCassandra(this.con);
		this.contractDao = new ContractCassandraDao(this.con);
		this.contractServices = new ContractServiceCassandraDao(this.con);
		this.countryDao = new CountryCassandraDao(this.con);
		this.vehicleDao = new VehicleCassandraDao(this.con);
	}

	@Override
	public User authenticateUser(String username) throws SQLException {

		return this.userDao.getUserByName(username);

	}

	@Override
	public List<Contract> getContractsByUser(String username) throws SQLException {
		return this.contractDao.getContractByUsername(username);

	}

	@Override
	public List<ContractService> getServicesByContractId(int contractId) throws SQLException {
		return this.contractServices.getServicesByContractId(contractId);
	}

	@Override
	public String getCountryNameByCountryId(int countryId) throws SQLException {
		return this.countryDao.getCountryNameByCountryId(countryId);
	}

	@Override
	public Vehicle getVehicleById(int VehicleId) throws SQLException {
		return this.vehicleDao.getVehicleById(VehicleId);
	}

	@Override
	public Contract getContractByVehicleId(int vehicleId) throws SQLException {
		return this.contractDao.getContractByVehicleId(vehicleId);
	}

}
