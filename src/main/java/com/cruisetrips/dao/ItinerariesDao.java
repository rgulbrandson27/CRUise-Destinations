package com.cruisetrips.dao;

import java.util.List;
import java.util.Optional;

import com.cruisetrips.entity.Itineraries;

public interface ItinerariesDao {
	
		
//		GET / READ
		
		List<Itineraries> getAllItineraries();	
		
	
//		GET / READ
		
		List<Itineraries> getItineraryById(Long itineraryId);

		
		
//		POST / CREATE

		Optional<Itineraries> createItinerary(int numberOfDays, int numberOfPorts);
		

		
//		PUT / UPDATE

		Optional<Itineraries> updateItineraryDetails(Long itineraryId, int numberOfDays, int numberOfPorts, 
		int newNumberOfDays, int newNumberOfPorts);		
		
		
//		DELETE / DELETE
		
		Optional<Itineraries> deleteItinerary(Long itineraryId);
		
		
	}



