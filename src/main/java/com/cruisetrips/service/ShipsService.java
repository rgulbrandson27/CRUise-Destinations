package com.cruisetrips.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.cruisetrips.entity.Ships;

public interface ShipsService {
	

	List<Ships> getAllShips();    
	
	
	List<Ships> getShipById(Long shipId);
	
	
	Optional<Ships> createShip(String shipName, String shipSize, BigDecimal guestRating);
	
	
	Optional<Ships> updateShipDetails(Long shipId, String shipName, String shipSize, 
		     BigDecimal guestRating, String newShipName, String newshipSize, BigDecimal newGuestRating);
	
	Optional<Ships> deleteShip(Long shipId, String shipName);
	
	}