package com.cruisetrips.service;

import java.util.List;
import java.util.Optional;

import com.cruisetrips.entity.Itineraries;

public interface ItinerariesService {

	
	List<Itineraries> getAllItineraries();	
	

	
	List<Itineraries> getItineraryById(Long itineraryId);



	Optional<Itineraries> createItinerary(int numberOfDays, int numberOfPorts);
	


	Optional<Itineraries> updateItineraryDetails(Long itineraryId, int numberOfDays, int numberOfPorts, 
	int newNumberOfDays, int newNumberOfPorts);		
	

	
	Optional<Itineraries> deleteItinerary(Long itineraryId);
	
	
}
