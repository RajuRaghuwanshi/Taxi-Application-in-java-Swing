package Utility;

import POJO.Person;

public class Driver_Info extends Person{
	
	private String driver_id;
	private int status;
	
	public Driver_Info() {
		super();
	}

	public Driver_Info(String driver_id, int status) {
		super();
		this.driver_id = driver_id;
		this.status = status;
	}
	public String getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}

	public int isStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
