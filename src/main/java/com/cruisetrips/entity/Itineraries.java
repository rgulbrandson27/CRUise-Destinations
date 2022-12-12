package com.cruisetrips.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder		

public class Itineraries {

	private Long itineraryId;
	private int numberOfDays;
	private int numberOfPorts;

	}

