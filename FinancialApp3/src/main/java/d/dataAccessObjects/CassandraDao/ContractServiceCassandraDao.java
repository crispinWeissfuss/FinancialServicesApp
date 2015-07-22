package d.dataAccessObjects.CassandraDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import b.dataTransferObjects.ContractService;
import d.dataAccessObjects.Dao.ContractServicesDao;

public class ContractServiceCassandraDao implements ContractServicesDao {

	Connection con = null;
	private static final String QUERY = "SELECT * FROM financialserviceapp.service WHERE contract_id = ";

	public ContractServiceCassandraDao(Connection con) {
		this.con = con;
	}

	@Override
	public List<ContractService> getServicesByContractId(int contractId) throws SQLException {

		ResultSet rs = this.executeQuery(contractId);
		List<ContractService> listContractServices = this.mapResultSetToListContracts(rs);

		return listContractServices;

	}

	private ResultSet executeQuery(int contractId) throws SQLException {
		String detailedQuery = QUERY + contractId + " ALLOW FILTERING";
		System.out.println(detailedQuery);

		PreparedStatement statement = this.con.prepareStatement(detailedQuery);

		ResultSet rs = statement.executeQuery();
		return rs;

	}

	private List<ContractService> mapResultSetToListContracts(ResultSet rs) throws SQLException {

		List<ContractService> listContractServices = new ArrayList<ContractService>();

		while (rs.next()) {
			ContractService currContractService = new ContractService();

			currContractService.setContractId(rs.getInt("contract_id"));
			currContractService.setDescription(rs.getString("description"));
			currContractService.setStartDate(rs.getString("start_time"));
			currContractService.setEndDate(rs.getString("end_time"));
			currContractService.setServiceId(rs.getInt("service_id"));
			currContractService.setCountry_Id(rs.getInt("country_id"));

			listContractServices.add(currContractService);

		}

		return listContractServices;
	}

}
