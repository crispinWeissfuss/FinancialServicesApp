package dataAccessObjects.accesslayer;

import java.sql.SQLException;

import dataTransferObjects.User;

public interface DbAccessLayer {

	User authenticateUser(String username) throws ClassNotFoundException, SQLException;

}
