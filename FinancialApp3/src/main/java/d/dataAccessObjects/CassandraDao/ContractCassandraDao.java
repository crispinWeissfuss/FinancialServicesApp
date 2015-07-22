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
	private static final String QUERY = "SELECT * FROM financialserviceapp.contract WHERE username = ?";

	public ContractCassandraDao(Connection con) {
		this.con = con;
	}

	@Override
	public List<Contract> getContractByUsername(String username) throws SQLException {
		ResultSet rs = this.executeQuery(username);
		List<Contract> listContracts = this.mapResultSetToListContracts(rs);
		System.out.println(listContracts.toString());
		return listContracts;
	}

	private ResultSet executeQuery(String username) throws SQLException {
		logger.info("Query" + QUERY);

		PreparedStatement statement = this.con.prepareStatement(QUERY);
		statement.setString(1, username);

		ResultSet rs = statement.executeQuery();
		return rs;

	}

	private List<Contract> mapResultSetToListContracts(ResultSet rs) throws SQLException {

		List<Contract> listContracts = new ArrayList<Contract>();

		while (rs.next()) {
			Contract currContract = new Contract();
			currContract.setUsername(rs.getString("username"));
			currContract.setEndTimestamp(rs.getDate("end_time"));
			currContract.setType(rs.getString("type_of_contract"));
			currContract.setLeasingRate(rs.getDouble("leasing_rate"));
			currContract.setVehicleId(rs.getInt("vehicle_id"));
			currContract.setContract_id(rs.getInt("contract_id"));
			currContract.setStartTimestamp(rs.getDate("start_time"));
			listContracts.add(currContract);

		}

		return listContracts;
	}

}
