package services;

import dataAccessObjects.UserDao;
import dataAccessObjects.UserDaoCassandra;
import dataTransferObjects.User;

public class ServicesImpl implements Services {

	public ServicesImpl() {
	}

	@Override
	public User authentificateUser(String username, String password) {

		UserDao accessUser = new UserDaoCassandra();
		User user = accessUser.getUserByName(username);

		if(this.checkPassword(password, user.getPassword())){
			
		}else{ // passwords are not matching --> return empty user
			return new User();
		}
		
		return user;
	}

	private boolean checkPassword(String enteredPassword, String dbPassword) {

		if (enteredPassword.equals(dbPassword)) {
			return true;
		}
		return false;

	}

}
