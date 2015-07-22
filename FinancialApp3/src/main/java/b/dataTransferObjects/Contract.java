package b.dataTransferObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

	public Date getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Date getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(Date endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

}
