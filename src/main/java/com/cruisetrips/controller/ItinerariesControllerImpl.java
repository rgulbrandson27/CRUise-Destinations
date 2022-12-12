package com.cruisetrips.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cruisetrips.entity.Itineraries;
import com.cruisetrips.service.ItinerariesService;

	
	@RestController
	public class ItinerariesControllerImpl implements ItinerariesController {
		
	@Autowired
	private ItinerariesService itinerariesService;

	@Override
	public List<Itineraries> getAllItineraries() {
		return itinerariesService.getAllItineraries();
	}
		
	@Override
	public List<Itineraries> getItineraryById(Long itineraryId) {
		return itinerariesService.getItineraryById(itineraryId);
	}
	@Override
	public Optional<Itineraries> createItinerary(int numberOfDays, int numberOfPorts) {
		return Optional.ofNullable(Itineraries.builder().numberOfDays(numberOfDays).numberOfPorts(numberOfPorts).build());
	}
		
	@Override
	public Optional<Itineraries> updateItineraryDetails(long itineraryId, int numberOfDays, int numberOfPort, 
		int newNumberOfDays, int newNumberOfPorts)  {
		return Optional.empty();
	}
		
	@Override
	public Optional<Itineraries> deleteItinerary(long itineraryId) {
		return Optional.empty();

	}
}
