package com.cruisetrips.entity;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Excursions {

	private Long excursionId;
	private String excursionName;
	private String exertionLevel;
	private BigDecimal adultPrice;
	private BigDecimal childPrice;
	
	}

