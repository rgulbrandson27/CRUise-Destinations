package com.cruisetrips.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.cruisetrips.entity.Excursions;

public interface ExcursionsDao {
	

//	GET / READ
	
	List<Excursions> getAllExcursions();	
	
	
	
//	GET / READ
	
	List<Excursions> getExcursionById(Long excursionId);

	
	
//	POST / CREATE

	Optional<Excursions> createExcursion(String excursionName, String exertionLevel, BigDecimal adultPrice, BigDecimal childPrice);
	

	
//	PUT / UPDATE

	Optional<Excursions> updateExcursionDetails(Long excursionId, String excursionName, String exertionLevel, BigDecimal adultPrice, BigDecimal childPrice, 
			String newExcursionName, String newExertionLevel, BigDecimal newAdultPrice, BigDecimal newChildPrice);		
	
	
//	DELETE / DELETE
	
	 Optional<Excursions> deleteExcursion(Long excursionId, String excursionName);
	
}


