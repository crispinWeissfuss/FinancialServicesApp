package dataAccessObjects.accesslayer;

import dataTransferObjects.User;

public interface DbAccessLayer {

	User authenticateUser(String username, String password);
	
}
