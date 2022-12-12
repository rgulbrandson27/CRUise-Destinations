package com.cruisetrips.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ports {
	
	private Long portId;
	private String portAbbr;
	private String portLocation;

	}
	