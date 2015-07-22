package dataTransferObjects;


public class ContractService {

	private int serviceId;
	private String description;
	private String startDate;
	private String endDate;
	private int contractId;
	private int country_Id;
	private String countryName;

	public ContractService() {
		// TODO Auto-generated constructor stub
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public int getCountry_Id() {
		return country_Id;
	}

	public void setCountry_Id(int country_Id) {
		this.country_Id = country_Id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
