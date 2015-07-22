package dataAccessObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataTransferObjects.Contract;
import dataTransferObjects.User;

public class ContractCassandraDao implements ContractDao {

	Connection con = null;
	private static final String QUERY = "SELECT * FROM financialserviceapp.contract WHERE username = ";

	public ContractCassandraDao(Connection con) {
		this.con = con;
	}

	@Override
	public List<Contract> getContractByUsername(String username) throws SQLException {
		ResultSet rs = this.executeQuery(username);
		List<Contract> listContracts = this.mapResultSetToListContracts(rs);

		return listContracts;
	}

	private ResultSet executeQuery(String username) throws SQLException {
		String detailedQuery = QUERY + "\"" + username + "\"";

		PreparedStatement statement = this.con.prepareStatement(detailedQuery);

		ResultSet rs = statement.executeQuery();
		return rs;

	}

	private List<Contract> mapResultSetToListContracts(ResultSet rs) throws SQLException {

		List<Contract> listContracts = new ArrayList<Contract>();

		while (rs.next()) {
			Contract currContract = new Contract();
			currContract.setUsername(rs.getString("username"));
			currContract.setEndTime(rs.getString("end_time"));
			currContract.setType(rs.getString("type_of_contract"));
			currContract.setStartTime(rs.getString("start_time"));
			currContract.setLeasingRate(rs.getDouble("leasing_rate"));
			currContract.setVehicle(rs.getInt("vehicle_id"));
			listContracts.add(currContract);

		}

		return listContracts;
	}

}
