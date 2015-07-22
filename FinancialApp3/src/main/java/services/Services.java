package services;

import java.sql.SQLException;

import dataTransferObjects.User;

public interface Services {

	User authentificateUser(String username, String password) throws ClassNotFoundException, SQLException;

}
