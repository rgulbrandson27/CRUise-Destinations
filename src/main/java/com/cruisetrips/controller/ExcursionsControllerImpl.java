package com.cruisetrips.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cruisetrips.entity.Excursions;
import com.cruisetrips.service.ExcursionsService;

@RestController
public class ExcursionsControllerImpl implements ExcursionsController {
	
	@Autowired
	private ExcursionsService excursionsService;

	@Override
	public List<Excursions> getAllExcursions() {
		return excursionsService.getAllExcursions();
	}
		
	@Override
	public List<Excursions> getExcursionById(Long excursionId) {
		return excursionsService.getExcursionById(excursionId);
	}
	
	@Override
	public Optional<Excursions> createExcursion(String excursionName, String exertionLevel, BigDecimal adultPrice,
			BigDecimal childPrice) {
		return Optional.ofNullable(Excursions.builder().excursionName(excursionName).exertionLevel(exertionLevel).
				adultPrice(adultPrice).childPrice(childPrice).build());
		}
		
	@Override
	public Optional<Excursions> updateExcursionDetails(long excursionId, String excursionName, String exertionLevel,
			BigDecimal adultPrice, BigDecimal childPrice, String newExcursionName, String newExertionLevel,
			BigDecimal newAdultPrice, BigDecimal newChildPrice) {
			return Optional.empty();
	}
		
	@Override
	public Optional<Excursions> deleteExcursion(long excursionId, String excursionName) {
		return Optional.empty();
	
	}

}
