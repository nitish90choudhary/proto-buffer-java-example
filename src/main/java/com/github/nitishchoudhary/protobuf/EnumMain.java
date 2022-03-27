package com.github.nitishchoudhary.protobuf;

import com.github.nitishchoudhary.Person;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import main.PersonOuterClass;

public class EnumMain {

	public static void main(String[] args) throws InvalidProtocolBufferException {

		System.out.println("Person example");
		PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder()
				.setFirstName("John").addMiddleName("K").addMiddleName("MS")
				.setLastName("Doe")
				.setAge(32)
				.setDateOfBirth(PersonOuterClass.Date.newBuilder().setDay(1).setMonth(12).setYear(1988)
						.build())
				.addPhoneNumber("012321344")
				.addPhoneNumber("7883029879")
				.addPhoneNumber("9079687546")
				.setEyeColor(PersonOuterClass.Person.EyeColor.BLUE)
				.addAddresses(PersonOuterClass.Person.Address.newBuilder()
						.setAddressLine1("Avent 2342")
						.setAddressLine2("Amsterdam oost")
						.setZipCode("1111BR")
						.setCity("Amsterdam")
						.setCountry("Netherlands")
						.build())
				.build();

		System.out.println(person);

		String jsonString = JsonFormat.printer().print(person);
		System.out.println("json data \n" + jsonString);
		Person.Builder builder2 = Person.newBuilder();

		JsonFormat.parser().ignoringUnknownFields()
				.merge(jsonString, builder2);
		System.out.println("JSON AFTER PARSING\n" + builder2);
	}
}
