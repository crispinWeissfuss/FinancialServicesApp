package d.dataAccessObjects.Dao;

import java.sql.SQLException;

import b.dataTransferObjects.User;

public interface UserDao {

	public User getUserByName(String username) throws SQLException;
	
}
