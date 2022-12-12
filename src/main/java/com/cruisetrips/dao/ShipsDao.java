package com.cruisetrips.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.cruisetrips.entity.Ships;


public interface ShipsDao {			//This interface provides the abstract methods - no returns

	
//	GET ALL / READ
	
	List<Ships> getAllShips();	
	
	
	
//	GET BY ID / READ
	
	List<Ships> getShipById(Long shipId);

	
	
//	POST / CREATE

	Optional<Ships> createShip(String shipName, String shipSize, BigDecimal guestRating);
	

	
//	PUT / UPDATE

	Optional<Ships> updateShipDetails(Long shipId, String shipName, String shipSize, BigDecimal guestRating,
			String newShipName, String newShipSize, BigDecimal newGuestRating);		
	
	
//	DELETE / DELETE
	
	Optional<Ships> deleteShip(Long shipId, String shipName);
	
	
}
