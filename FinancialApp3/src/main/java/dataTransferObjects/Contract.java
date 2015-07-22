package dataTransferObjects;

import java.util.List;

import enumerations.EnumContractType;

public class Contract {

	private int contract_id;
	private String type;
	private String startTime;
	private String endTime;
	private double leasingRate;
	private int vehicle;
	private String username;

	private List<ContractService> Services;

	public Contract() {
		// TODO Auto-generated constructor stub
	}

	public int getContract_id() {
		return contract_id;
	}

	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public double getLeasingRate() {
		return leasingRate;
	}

	public void setLeasingRate(double leasingRate) {
		this.leasingRate = leasingRate;
	}

	public int getVehicle() {
		return vehicle;
	}

	public void setVehicle(int vehicle) {
		this.vehicle = vehicle;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List getServices() {
		return Services;
	}

	public void setServices(List services) {
		Services = services;
	}

}
