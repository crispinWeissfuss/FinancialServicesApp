package services;

import dataTransferObjects.User;

public interface Services {

	User authentificateUser(String username, String password);

}
