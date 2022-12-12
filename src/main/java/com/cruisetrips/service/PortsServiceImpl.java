package com.cruisetrips.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cruisetrips.dao.PortsDao;
import com.cruisetrips.entity.Ports;


@Service
public class PortsServiceImpl implements PortsService {

	@Autowired 
	private PortsDao portsDao;
		
	public List<Ports> getAllPorts() {
		return portsDao.getAllPorts();
		}

	@Transactional(readOnly = true)
	@Override
	public List<Ports> getPortById(Long portId) {
		return portsDao.getPortById(portId);
		}

	@Transactional
	@Override
	public Optional<Ports> createPort(String portAbbr, String portLocation) {
			return portsDao.createPort(portAbbr, portLocation); 
		}
	
	@Transactional
	@Override
	public Optional<Ports> updatePortDetails(Long portId, String portAbbr, String portLocation, String newPortAbbr, String newPortLocation) {
		return portsDao.updatePortDetails(portId, portAbbr, portLocation, newPortAbbr, newPortLocation);
		}
	
	@Transactional
	@Override
	public Optional<Ports> deletePort(Long portId, String portAbbr) {
		return portsDao.deletePort(portId, portAbbr);
		}
	}

