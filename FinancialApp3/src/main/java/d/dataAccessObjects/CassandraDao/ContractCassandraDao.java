package d.dataAccessObjects.CassandraDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import b.dataTransferObjects.Contract;
import d.dataAccessObjects.Dao.ContractDao;

public class ContractCassandraDao implements ContractDao {

	Connection con = null;
	private final static Logger logger = Logger.getLogger(ContractCassandraDao.class);
	private static final String QUERY_BY_USERNAME = "SELECT * FROM financialserviceapp.contract WHERE username = ?";
	private static final String QUERY_BY_VEHICLE_ID = "SELECT * FROM financialserviceapp.contract WHERE vehicle_id = ? ALLOW FILTERING";

	public ContractCassandraDao(Connection con) {
		this.con = con;
	}

	@Override
	public List<Contract> getContractByUsername(String username) throws SQLException {
		ResultSet rs = this.executeQueryByUsername(username);
		List<Contract> listContracts = this.mapResultSetToListContracts(rs);
		return listContracts;
	}

	@Override
	public Contract getContractByVehicleId(int vehicleId) throws SQLException {
		ResultSet rs = this.executeQueryByVehicleId(vehicleId);
		Contract contract = this.mapResultSetTContract(rs);
		return contract;
	}

	private ResultSet executeQueryByUsername(String username) throws SQLException {
		logger.info("Query" + QUERY_BY_USERNAME);

		PreparedStatement statement = this.con.prepareStatement(QUERY_BY_USERNAME);
		statement.setString(1, username);

		ResultSet rs = statement.executeQuery();
		return rs;

	}

	private ResultSet executeQueryByVehicleId(int vehicleId) throws SQLException {
		logger.info("Query" + QUERY_BY_VEHICLE_ID);

		PreparedStatement statement = this.con.prepareStatement(QUERY_BY_VEHICLE_ID);
		statement.setInt(1, vehicleId);

		ResultSet rs = statement.executeQuery();
		return rs;

	}

	private List<Contract> mapResultSetToListContracts(ResultSet rs) throws SQLException {

		List<Contract> listContracts = new ArrayList<Contract>();

		while (rs.next()) {

			Contract currContract = this.mapResultSetTContract(rs);
			listContracts.add(currContract);

		}

		return listContracts;
	}

	private Contract mapResultSetTContract(ResultSet rs) throws SQLException {
		Contract contract = new Contract();
		contract.setUsername(rs.getString("username"));
		contract.setEndTimestamp(rs.getDate("end_time"));
		contract.setType(rs.getString("type_of_contract"));
		contract.setLeasingRate(rs.getDouble("leasing_rate"));
		contract.setVehicleId(rs.getInt("vehicle_id"));
		contract.setContract_id(rs.getInt("contract_id"));
		contract.setStartTimestamp(rs.getDate("start_time"));
		return contract;
	}
}
