package com.demo.car.data;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.get_json_object;

import java.util.concurrent.*;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQueryException;

public class CarSparkStreamingSQL {

	public static void main(String[] args) throws InterruptedException, StreamingQueryException, TimeoutException {
		SparkConf conf = new SparkConf().setAppName("Car-Data-Streaming").setMaster("local[*]");

		SparkSession spark = SparkSession.builder().config(conf).getOrCreate();

		Dataset<Row> carInfoDF = spark.readStream()
				.format("kafka")
				.option("kafka.bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094") //BROKERS
				.option("subscribe", "carMultiBroker") //KAFKA TOPIC NAME
				.load()
				.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)") //FIELDS
				.select(get_json_object(col("value"), "$.carId").alias("carId"),
						get_json_object(col("value"), "$.customerId").alias("customerId"),
						get_json_object(col("value"), "$.carType").alias("carType"),
						get_json_object(col("value"), "$.bootLoad").alias("bootLoad"),
						get_json_object(col("value"), "$.speed").alias("speed"),
						get_json_object(col("value"), "$.noOfPassengers").alias("noOfPassengers"),
						get_json_object(col("value"), "$.speed").alias("speed"),
						get_json_object(col("value"), "$.time").alias("time"),
						get_json_object(col("value"), "$.batteryChargeLeft").alias("batteryChargeLeft"),
						get_json_object(col("value"), "$.GPSLocation.latitude").alias("latitude"),
						get_json_object(col("value"), "$.GPSLocation.longitude").alias("longitude"));

		Dataset<Row> carInfo = carInfoDF.filter(col("carType").equalTo("SUV")); //FILTERING A PARTICULAR CAR TYPE
		carInfo.writeStream().format("json")
				.option("checkpointLocation",
						"CarDataSpark/check-point")
				.option("path", "CarDataSpark/out/SUV").start()
				.awaitTermination();


	}
}