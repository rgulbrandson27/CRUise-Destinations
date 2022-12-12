package com.cruisetrips.entity;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Ships {
	
	private Long shipId;
	private String shipName;
	private String shipSize;
	private BigDecimal guestRating;
	
}


