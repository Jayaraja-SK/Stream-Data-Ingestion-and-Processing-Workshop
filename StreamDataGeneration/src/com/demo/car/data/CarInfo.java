package com.demo.car.data;

import com.google.gson.Gson;

class CarInfo {

	private String carId;
	private String driverId;
	private String customerId;
	private String carType;
	private int bootLoad;
	private float batteryChargeLeft;
	private int noOfPassengers;
	private int speed;
	private String time;
	Location GPSLocation;

	public CarInfo() {

	}

	public CarInfo(String carId, String driverId, String customerId, String carType, int bootLoad, int speed, int noOfPassengers, float batteryChargeLeft, String time, Location GPSLocation) {
		this.carId=carId;
		this.customerId=customerId;
		this.carType=carType;
		this.bootLoad=bootLoad;
		this.speed=speed;
		this.noOfPassengers=noOfPassengers;
		this.batteryChargeLeft=batteryChargeLeft;
		this.time=time;
		this.GPSLocation=GPSLocation;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}	

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getBootLoad() {
		return bootLoad;
	}

	public void setBootLoad(int bootLoad) {
		this.bootLoad=bootLoad;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public float getBatteryChargeLeft() {
		return batteryChargeLeft;
	}

	public void setBatteryChargeLeft(float batteryChargeLeft) {
		this.batteryChargeLeft=batteryChargeLeft;
	}
	
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers=noOfPassengers;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time=time;
	}
	
	public Location getLocation() {
		return GPSLocation;
	}

	public void setLocation(Location location) {
		this.GPSLocation=GPSLocation;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}

class Location {
	private double latitude;
	private double longitude;

	public Location(double latitude, double longitude) {
		super();
		this.latitude=latitude;
		this.longitude=longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude=latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double lon) {
		this.longitude=longitude;
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}