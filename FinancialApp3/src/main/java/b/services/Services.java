package b.services;

import java.sql.SQLException;

import a.dataTransferObjects.User;

public interface Services {

	User authentificateUser(String username, String password) throws ClassNotFoundException, SQLException;

}
