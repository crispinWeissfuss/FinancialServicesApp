package c.internalServices;

import java.sql.SQLException;
import java.text.ParseException;

import javax.ws.rs.PathParam;

import b.dataTransferObjects.Contract;
import b.dataTransferObjects.User;

public interface Services {

	User authentificateUser(String username, String password) throws ClassNotFoundException, SQLException;

	Contract getCountryServiceProposal(String countryId, int vehicleId, String startDate, String endDate) throws SQLException, ParseException;

}
