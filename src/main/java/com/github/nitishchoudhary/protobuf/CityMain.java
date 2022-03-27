package com.github.nitishchoudhary.protobuf;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import address.CityOuterClass;

public class CityMain {

	public static void main(String[] args) {
		System.out.println("Hello  World");

		CityOuterClass.City city = CityOuterClass.City.newBuilder()
				.setCityName("Amsterdam").setZipcode("1102BR").setCountry("Netherlands")
				.build();
		System.out.println(city);

		// write protocol buffer binary to  file
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("city_message.bin");
			city.writeTo(fos);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// send protocol binary to  network
		//byte[] bytes = city.toByteArray();

		//Read from file

		try {
			FileInputStream fis = new FileInputStream("city_message.bin");
			CityOuterClass.City cityFromFile = CityOuterClass.City.parseFrom(fis);
			System.out.println("City from file \n" + cityFromFile);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
