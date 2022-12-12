package com.cruisetrips.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cruisetrips.entity.Ships;
import com.cruisetrips.service.ShipsService;

@RestController
public class ShipsControllerImpl implements ShipsController {
	
	@Autowired
	private ShipsService shipsService;

	@Override
	public List<Ships> getAllShips() {
		return shipsService.getAllShips();
	}
	
	@Override
	public List<Ships> getShipById(Long shipId) {
		return shipsService.getShipById(shipId);
	}
	@Override
	public Optional<Ships> createShip(String shipName, String shipSize, BigDecimal guestRating) {
		return Optional.ofNullable(Ships.builder().shipName(shipName).shipSize(shipSize).guestRating(guestRating).build());
	}
	
	@Override
	public Optional<Ships> updateShipDetails(long shipId, String shipName, String shipSize, BigDecimal guestRating,
		String newShipName, String newShipSize, BigDecimal newGuestRating) {
		return Optional.empty();
	}
	@Override
	public Optional<Ships> deleteShip(long shipId, String shipName) {
		return Optional.empty();

	}
}




