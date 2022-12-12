package com.cruisetrips.service;

import java.util.List;
import java.util.Optional;

import com.cruisetrips.entity.Ports;

public interface PortsService {
	
	List<Ports> getAllPorts();    

	
	List<Ports> getPortById(Long portId);
	
	
	Optional<Ports> createPort(String portAbbr, String portLocation);
	
	
	Optional<Ports> updatePortDetails(Long portId, String portAbbr, String portLocation, String newPortAbbr, String newPortLocation);
	
	
	Optional<Ports> deletePort(Long PortId, String portAbbr);

}
