package c.dataAccessObjects.CassandraDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import c.dataAccessObjects.Dao.CountryDao;

public class CountryCassandraDao implements CountryDao {

	Connection con = null;
	private static final String QUERY = "SELECT * FROM financialserviceapp.country WHERE country_id = ";

	public CountryCassandraDao(Connection con) {
		this.con = con;
	}

	@Override
	public String getCountryNameByCountryId(int countryId) throws SQLException {
		return this.executeQuery(countryId);

	}

	private String executeQuery(int countryId) throws SQLException {
		String detailedQuery = QUERY + countryId;
		System.out.println(detailedQuery);

		PreparedStatement statement = this.con.prepareStatement(detailedQuery);

		ResultSet rs = statement.executeQuery();
		return rs.getString("description");

	}

}
