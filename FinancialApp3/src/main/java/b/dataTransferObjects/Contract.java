package b.dataTransferObjects;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class Contract {

	private int contract_id;
	private String type;
	private String startTime;
	private Date startTimestamp;
	private Date endTimestamp;
	private String endTime;
	private double leasingRate;
	private double newRate;
	private Vehicle vehicle;
	private int vehicleId;
	private String username;
	private String name;

	private List<ContractService> Services = new ArrayList<ContractService>();

	public Contract() {
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

	public double getLeasingRate() {
		return leasingRate;
	}

	public void setLeasingRate(double leasingRate) {
		this.leasingRate = leasingRate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
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

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public void setServices(List<ContractService> services) {
		Services = services;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getNewRate() {
		if (this.newRate == 0.00) {
			return this.leasingRate;
		}
		return newRate;
	}

	public void setNewRate(double newRate) {
		this.newRate = newRate;
	}

	public String getStartTime() {
		return dtoUtils.formatDateIntoDdMmYyyy(this.startTimestamp);
	}

	public String getEndTime() {
		return dtoUtils.formatDateIntoDdMmYyyy(this.endTimestamp);
	}

	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public void setEndTimestamp(Date endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	public void addContractService(ContractService contractService) {
		this.Services.add(contractService);
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
