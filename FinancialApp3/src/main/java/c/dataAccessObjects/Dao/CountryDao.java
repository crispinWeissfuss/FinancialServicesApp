package c.dataAccessObjects.Dao;

import java.sql.SQLException;

public interface CountryDao {

	String getCountryNameByCountryId(int countryId) throws SQLException;

}
