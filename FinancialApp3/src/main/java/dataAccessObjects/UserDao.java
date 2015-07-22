package dataAccessObjects;

import dataTransferObjects.User;

public interface UserDao {

	public User getUserByName(String name);
	
}
