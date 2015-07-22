package c.internalServices;

import java.sql.SQLException;

import b.dataTransferObjects.User;

public interface Services {

	User authentificateUser(String username, String password) throws ClassNotFoundException, SQLException;

}
