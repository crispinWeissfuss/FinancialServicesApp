package dataTransferObjects;

import java.util.List;

public class User {
	private String firstName;
	private String Lastname;
	private String password;
	private List<Contract> listOfContracts = null;
	private List<Route> listOfRoutes = null;

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

	public List<Route> getListOfRoutes() {
		return listOfRoutes;
	}

	public void setListOfRoutes(List<Route> listOfRoutes) {
		this.listOfRoutes = listOfRoutes;
	}

}
