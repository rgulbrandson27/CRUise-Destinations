package com.cruisetrips.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cruisetrips.entity.Ports;

@Component
@Service


public class PortsDaoImpl implements PortsDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
//	GET ALL-----------------------------------------------------------------------------
	
	@Override
	public List<Ports> getAllPorts() {
	
		String sql = ""
			+ "SELECT * "
			+ "FROM ports ";
		
		return jdbcTemplate.query(sql, new RowMapper<Ports>() {
			
	@Override	
	public Ports mapRow(ResultSet rs, int rowNum) throws SQLException {		
			return Ports.builder()
				.portId(rs.getLong("port_id"))	
				.portAbbr(new String(rs.getString("port_abbr")))
				.portLocation(new String(rs.getString("port_location")))   
				.build();

		}});
	}
	
//	GET BY ID-----------------------------------------------------------------------------
	
	
	@Override
	public List<Ports> getPortById(Long portId) {
		
		String sql = ""
			+ "SELECT * "
			+ "FROM ports "
			+ "WHERE port_id = :port_id";
		
	Map<String, Long> params = new HashMap<>();			
		params.put("port_id", portId);		
		
		return jdbcTemplate.query(sql, params, new RowMapper<Ports>() {  
	
		@Override
		public Ports mapRow(ResultSet rs, int rowNum) throws SQLException {
			return Ports.builder()
				.portId(rs.getLong("port_id"))	
				.portAbbr(new String(rs.getString("port_abbr")))
				.portLocation(new String(rs.getString("port_name")))   
				.build();
		}});		
	}

//	POST-----------------------------------------------------------------------------
	
					
	@Override
	public Optional<Ports> createPort(String portAbbr, String portLocation) {	
		String sql = ""
		+ "INSERT INTO ports (" + "port_abbr, port_location,"
		+ ") VALUES (" +  ":port_abbr, :port_location)";
	
	Map<String, Object> params = new HashMap<>();				
	params.put("port_abbr", portAbbr);					
	params.put("port_location", portLocation);
	
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Ports.builder()					
			.portAbbr(portAbbr).portLocation(portLocation).build());	
	}

//	PUT-----------------------------------------------------------------------------

	@Override
	public Optional<Ports> updatePortDetails(Long portId, String portAbbr, String portLocation, String newPortAbbr, String newPortLocation) {

	String sql = ""
		+ "UDPATE ports SET port_abbr = :new_port_abbr, port_location = :new_port_location "
		+ "WHERE port_id = port_id";
	
		Map<String, Object> params = new HashMap<>();
		params.put("port_id", portId);
		params.put("port_abbr",  portAbbr);
		params.put("port_location", portLocation);
		params.put("new_port_abbr", newPortAbbr);
		params.put("new_port_location", newPortLocation);
	
			jdbcTemplate.update(sql, params);
			return Optional.ofNullable(Ports.builder()
			.portId(portId).portAbbr(newPortAbbr).portLocation(newPortLocation).build());
	}
//	DELETE-----------------------------------------------------------------------------

	@Override
	public Optional<Ports> deletePort(Long portId, String portAbbr) {    

		String sql = ""
			+ "DELETE FROM ports WHERE "
			+ "port_id = :port_id; AND port_abbr = :port_abbr";

			
		Map<String, Object> params = new HashMap<>();				
		params.put("port_id", portId);					
			
			jdbcTemplate.update(sql, params);
			return Optional.ofNullable(Ports.builder().portId(portId).portAbbr(portAbbr).build());

		}
	}	





























