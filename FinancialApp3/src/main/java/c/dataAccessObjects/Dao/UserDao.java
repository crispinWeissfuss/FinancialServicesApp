package c.dataAccessObjects.Dao;

import java.sql.SQLException;

import a.dataTransferObjects.User;

public interface UserDao {

	public User getUserByName(String username) throws SQLException;
	
}
