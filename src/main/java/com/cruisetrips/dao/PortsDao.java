package com.cruisetrips.dao;

import java.util.List;
import java.util.Optional;

import com.cruisetrips.entity.Ports;


public interface PortsDao {

		
//		GET / READ
		
		List<Ports> getAllPorts();	
		
		
		
//		GET / READ
		
		List<Ports> getPortById(Long portId);

		
		
//		POST / CREATE

		Optional<Ports> createPort(String portId, String portLocation);
		

		
//		PUT / UPDATE
		Optional<Ports> updatePortDetails(Long portId, String portAbbr, String portLocation, String newPortAbbr, String newPortLocation);
		
		
//		DELETE / DELETE
		
		Optional<Ports> deletePort(Long portId, String portAbbr);
		
		
	}

	

