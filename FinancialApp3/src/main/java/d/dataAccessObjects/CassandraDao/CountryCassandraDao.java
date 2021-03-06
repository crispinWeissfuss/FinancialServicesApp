package d.dataAccessObjects.CassandraDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import d.dataAccessObjects.Dao.CountryDao;

public class CountryCassandraDao implements CountryDao {

	Connection con = null;
	private static final String QUERY_BY_COUNTRY_ID = "SELECT * FROM financialserviceapp.country WHERE country_id = ?";

	public CountryCassandraDao(Connection con) {
		this.con = con;
	}

	@Override
	public String getCountryNameByCountryId(int countryId) throws SQLException {
		PreparedStatement statement = this.con.prepareStatement(QUERY_BY_COUNTRY_ID);
		statement.setInt(1, countryId);

		ResultSet rs = statement.executeQuery();
		return rs.getString("description");

	}

}
