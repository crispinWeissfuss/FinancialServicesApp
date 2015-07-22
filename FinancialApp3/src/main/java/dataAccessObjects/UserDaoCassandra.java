package dataAccessObjects;

import dataTransferObjects.User;

public class UserDaoCassandra implements UserDao {

	public UserDaoCassandra() {
	}

	@Override
	public User getUserByName(String name) {
		return this.userMock();
	}

	private User userMock() {

		User user = new User();
		user.setFirstName("Ned");
		user.setLastname("Stark");
		user.setPassword("Winter_Is_Coming");

		return user;

	}

}
