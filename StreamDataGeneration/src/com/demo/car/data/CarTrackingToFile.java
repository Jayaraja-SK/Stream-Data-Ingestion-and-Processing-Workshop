package com.demo.car.data;
import com.demo.car.data.MainFunctions.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CarTrackingToFile{

	public static void main(String[] args) throws InterruptedException,IOException {
		
		int fileno=0;
		
		while (true) {
			int count=0;
			String contents="";
			
			File file = new File("CarDataJson/"
					+ fileno + ".txt");
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
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
				
				bw.append(car.toString());
				
				count=count+1;

			}
			System.out.println("TOTAL NO. OF RECORDS COPIED TO FILE = "+count);
			Thread.sleep(1000);
			
			bw.flush();
			bw.close();
			
			fileno=fileno+1;
		}
	}
}