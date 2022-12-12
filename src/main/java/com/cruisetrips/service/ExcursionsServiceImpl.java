package com.cruisetrips.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cruisetrips.dao.ExcursionsDao;
import com.cruisetrips.entity.Excursions;

@Service
public class ExcursionsServiceImpl implements ExcursionsService {
	

	@Autowired 
	private ExcursionsDao excursionsDao;
		
	@Transactional(readOnly = true)
	@Override
	public List<Excursions> getAllExcursions() {
		return excursionsDao.getAllExcursions();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Excursions> getExcursionById(Long excursionId) {
		return excursionsDao.getExcursionById(excursionId);
	}

	@Transactional
	@Override
	public Optional<Excursions> createExcursion(String excursionName, String exertionLevel, BigDecimal adultPrice, BigDecimal childPrice) {
		return excursionsDao.createExcursion(excursionName, exertionLevel, adultPrice, childPrice);
	}
		
	@Transactional
	@Override
	public Optional<Excursions> updateExcursionDetails(Long excursionId, String excursionName, String exertionLevel, 
		BigDecimal adultPrice, BigDecimal childPrice, String newExcursionName, String newExertionLevel,
		BigDecimal newAdultPrice, BigDecimal newChildPrice) {
		return excursionsDao.updateExcursionDetails(excursionId, excursionName, exertionLevel, adultPrice, childPrice,
			newExcursionName, newExertionLevel, newAdultPrice, newChildPrice);
	}
	
	@Transactional
	@Override
	public Optional<Excursions> deleteExcursion(Long excursionId, String excursionName) {
		return excursionsDao.deleteExcursion(excursionId, excursionName);
		
		} 
}
