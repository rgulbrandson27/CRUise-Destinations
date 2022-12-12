package com.cruisetrips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication	(scanBasePackageClasses = {ComponentScanMarker.class})
public class CruiseTrips {

	public static void main(String[] args) {
		SpringApplication.run(CruiseTrips.class, args);
	}
}
