package POJO;

public class Vehicle {
	
	private String name;
	private String vehicle_number;
	private String fuel_type;
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(String name, String vehicle_number, String fuel_type) {
		super();
		this.name = name;
		this.vehicle_number = vehicle_number;
		this.fuel_type = fuel_type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVehicle_number() {
		return vehicle_number;
	}
	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}
	public String getFuel_type() {
		return fuel_type;
	}
	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}
}
