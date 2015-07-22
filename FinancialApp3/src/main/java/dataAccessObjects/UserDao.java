package dataAccessObjects;

import java.sql.SQLException;

import dataTransferObjects.User;

public interface UserDao {

	public User getUserByName(String username) throws SQLException;
	
}
