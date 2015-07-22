package a.dataTransferObjects;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class User {
	private String username;
	private String firstName;
	private String Lastname;
	private String password;
	private List<Contract> listOfContracts = null;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Contract> getListOfContracts() {
		return listOfContracts;
	}

	public void setListOfContracts(List<Contract> listOfContracts) {
		this.listOfContracts = listOfContracts;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {

		String userAsJson = null;

		ObjectMapper mapper = new ObjectMapper();
		try {
			userAsJson = mapper.writeValueAsString(this);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return userAsJson;
	}
}
