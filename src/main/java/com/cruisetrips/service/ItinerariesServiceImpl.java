package com.cruisetrips.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cruisetrips.dao.ItinerariesDao;
import com.cruisetrips.entity.Itineraries;

@Service
public class ItinerariesServiceImpl implements ItinerariesService {

	@Autowired 
	private ItinerariesDao itinerariesDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Itineraries> getAllItineraries() {
		return itinerariesDao.getAllItineraries();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Itineraries> getItineraryById(Long itineraryId) {		
		return itinerariesDao.getItineraryById(itineraryId);
	
	}

	@Override
	public Optional<Itineraries> createItinerary(int numberOfDays, int numberOfPorts) {
		
		return itinerariesDao.createItinerary(numberOfDays, numberOfPorts);
	}

	@Override
	public Optional<Itineraries> updateItineraryDetails(Long itineraryId, int numberOfDays, int numberOfPorts,
			int newNumberOfDays, int newNumberOfPorts) {
		return itinerariesDao.updateItineraryDetails(itineraryId, numberOfDays, numberOfPorts, newNumberOfDays, newNumberOfPorts);
	}
	
	@Transactional
	@Override
	public Optional<Itineraries> deleteItinerary(Long itineraryId) {
		return itinerariesDao.deleteItinerary(itineraryId);
	}
}
