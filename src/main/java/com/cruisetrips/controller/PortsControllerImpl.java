package com.cruisetrips.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cruisetrips.entity.Ports;
import com.cruisetrips.service.PortsService;

	
@RestController
public class PortsControllerImpl implements PortsController {
		
	@Autowired
	private PortsService portsService;

	@Override
	public List<Ports> getAllPorts() {
		return portsService.getAllPorts();
		}	
	@Override
	public List<Ports> getPortById(Long portId) {
		return portsService.getPortById(portId);
		}
	@Override
	public Optional<Ports> createPort(String portAbbr, String portLocation) {
		return Optional.ofNullable(Ports.builder().portAbbr(portAbbr).portLocation(portLocation).build());
		}
	@Override
	public Optional<Ports> updatePortDetails(Long portId, String portAbbr, String portLocation, String newPortAbbr, String newPortLocation) {
		return Optional.empty();
		}
	@Override
	public Optional<Ports> deletePort(Long portId, String portAbbr) {
		return Optional.empty();

	}
}
