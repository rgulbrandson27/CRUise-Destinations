package com.cruisetrips.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.cruisetrips.entity.Excursions;

public interface ExcursionsService {
	
List<Excursions> getAllExcursions();    
	
	
List<Excursions> getExcursionById(Long excursionId);
	
	
Optional<Excursions> createExcursion(String excursionName, String exertionLevel, BigDecimal adultPrice, BigDecimal childPrice);
	
	
Optional<Excursions> updateExcursionDetails(Long excursionId, String excursionName, String exertionLevel, 
		     BigDecimal adultPrice, BigDecimal childPrice, String newExcursionName, String newExertionLevel,
		     BigDecimal newAdultPrice, BigDecimal newChildPrice);
	
Optional<Excursions> deleteExcursion(Long excursionId, String excursionName);

}
