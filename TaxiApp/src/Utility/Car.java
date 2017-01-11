package Utility;

import POJO.Vehicle;

public class Car extends Vehicle{
	
	private String car_id;
	private Driver_Info driver_info;
	
	
	public Car() {
		super();
	}

	public Car(String car_id, Driver_Info driver_info) {
		super();
		this.car_id = car_id;
		this.driver_info = driver_info;
	}

	public String getCar_id() {
		return car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	public Driver_Info getDriver_info() {
		return driver_info;
	}

	public void setDriver_info(Driver_Info driver_info) {
		this.driver_info = driver_info;
	}
	
	
	
}
