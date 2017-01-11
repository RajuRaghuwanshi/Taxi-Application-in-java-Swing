package Utility;

import POJO.Points;

public class Car_Location {
	
	private Car car_info;
	private Points points;
	
	public Car_Location(Car car_info, Points points) {
		super();
		this.car_info = car_info;
		this.points = points;
	}

	public Car getCar_info() {
		return car_info;
	}

	public void setCar_info(Car car_info) {
		this.car_info = car_info;
	}

	public Points getPoints() {
		return points;
	}

	public void setPoints(Points points) {
		this.points = points;
	}
	
	
}
