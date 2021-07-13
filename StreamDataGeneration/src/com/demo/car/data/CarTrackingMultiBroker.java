package com.demo.car.data;

import com.demo.car.data.MainFunctions.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class CarTrackingMultiBroker{

	public static void main(String[] args) throws InterruptedException {

		while (true) {
			int count=0;
			for (int i = 1; i <= new Random().nextInt(30); i++) {
				CarInfo car = new CarInfo();
				car.setCarId(Functions.generateRandomId());
				car.setCustomerId(Functions.generateRandomId());
				car.setCarType(Functions.generateRandomCarType());
				car.setSpeed(Functions.generateSpeed(car.getCarType()));
				car.setNoOfPassengers(Functions.generateNoOfPassengers(car.getCarType()));
				car.setBootLoad(Functions.generateBootLoad(car.getCarType()));
				car.setBatteryChargeLeft(Functions.generateChargeLeft(car.getCarType()));
				car.setTime(Functions.generateTime());
				Map<String, String> jw = Functions.randomLonLat(12, 15, 70, 80);
				car.setLocation(new Location(Double.parseDouble(jw.get("J")), Double.parseDouble(jw.get("W"))));
				
				SimpleKafkaProducer.sendDataToKafkaMultipleBroker(car.toString(), "carMultiBroker",car.getCarType()); //NOT ABLE TO CREATE A NEW BROKER
				
				count=count+1;
			}
			System.out.println("TOTAL NO. OF RECORDS SEND TO CONSUMER = "+count);
			Thread.sleep(1000);
		}
	}
}