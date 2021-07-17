package com.demo.car.data.MainFunctions;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public class Functions {
	public static int generateBootLoad(String carType) {
		if(carType=="SUV")
		{
			return new Random().nextInt(1500);
		}
		else if(carType=="Sedan")
		{
			return new Random().nextInt(500);
		}
		else if(carType=="Van")
		{
			return new Random().nextInt(2500);
		}
		else if(carType=="Hatchback")
		{
			return new Random().nextInt(350);
		}
		else if(carType=="Cabriolet")
		{
			return new Random().nextInt(400);
		}
		else if(carType=="Maybach")
		{
			return new Random().nextInt(800);
		}
		return 0;
	}
	
	public static int generateNoOfPassengers(String carType) {
		Random random = new Random();
		if(carType=="SUV")
		{
			return random.nextInt(8 - 1) + 1;
		}
		else if(carType=="Sedan")
		{
			return random.nextInt(5 - 1) + 1;
		}
		else if(carType=="Van")
		{
			return random.nextInt(12 - 1) + 1;
		}
		else if(carType=="Hatchback")
		{
			return random.nextInt(5 - 1) + 1;
		}
		else if(carType=="Cabriolet")
		{
			return random.nextInt(2 - 1) + 1;
		}
		else if(carType=="Maybach")
		{
			return random.nextInt(4 - 1) + 1;
		}
		return 0;
	}

	public static int generateSpeed(String carType) {
		if(carType=="SUV")
		{
			return new Random().nextInt(180);
		}
		else if(carType=="Sedan")
		{
			return new Random().nextInt(200);
		}
		else if(carType=="Van")
		{
			return new Random().nextInt(80);
		}
		else if(carType=="Hatchback")
		{
			return new Random().nextInt(100);
		}
		else if(carType=="Cabriolet")
		{
			return new Random().nextInt(240);
		}
		else if(carType=="Maybach")
		{
			return new Random().nextInt(220);
		}
		return 0;
	}

	public static int generateChargeLeft(String carType) {
		return new Random().nextInt(100);
	}

	public static String generateRandomId() {
		return UUID.randomUUID().toString();
	}

	public static String generateRandomCarType() {
		String[] vehicleTypeArray = { "Sedan","SUV","Van","Hatchback","Cabriolet","Maybach"};
		return vehicleTypeArray[new Random().nextInt(vehicleTypeArray.length)];
	}
	
	public static Map<String, String> randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat) {
		BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
		String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();// 6 digits after the decimal
		db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
		String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
		Map<String, String> map = new HashMap<String, String>();
		map.put("J", lon);
		map.put("W", lat);
		return map;
	}
	
	public static String generateTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
	    return dtf.format(now);  
	}
}
