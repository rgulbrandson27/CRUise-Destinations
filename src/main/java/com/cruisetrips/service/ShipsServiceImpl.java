package com.cruisetrips.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cruisetrips.dao.ShipsDao;
import com.cruisetrips.entity.Ships;

@Service
public class ShipsServiceImpl implements ShipsService {

	@Autowired 
	private ShipsDao shipsDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Ships> getAllShips() {
		return shipsDao.getAllShips();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ships> getShipById(Long shipId) {
		return shipsDao.getShipById(shipId);
	}

	@Transactional
	@Override
	public Optional<Ships> createShip(String shipName, String shipSize, BigDecimal guestRating) {
		return shipsDao.createShip(shipName, shipSize, guestRating); 
	}
	@Transactional
	@Override
	public Optional<Ships> updateShipDetails(Long shipId, String shipName, String shipSize, BigDecimal guestRating, String newShipName,
			String newShipSize, BigDecimal newGuestRating) {
		return shipsDao.updateShipDetails(shipId, shipName, shipSize, guestRating, newShipName, newShipSize, newGuestRating);
	}
	@Transactional
	@Override
	public Optional<Ships> deleteShip(Long shipId, String shipName) {
		return shipsDao.deleteShip(shipId, shipName);
	
	} 
}