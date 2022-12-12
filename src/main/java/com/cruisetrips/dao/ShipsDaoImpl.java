package com.cruisetrips.dao;

import com.cruisetrips.entity.Ships;

import java.math.BigDecimal;
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


@Component
@Service				

public class ShipsDaoImpl implements ShipsDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
//	GET ALL-----------------------------------------------------------------------------
	
	@Override
	public List<Ships> getAllShips() {
	
		String sql = ""
			+ "SELECT * "
			+ "FROM ships ";
		
		
		return jdbcTemplate.query(sql, new RowMapper<Ships>() {
			
	@Override
	public Ships mapRow(ResultSet rs, int rowNum) throws SQLException {
		return Ships.builder()
			.shipId(rs.getLong("ship_id"))					
			.shipName(new String(rs.getString("ship_name")))   
			.shipSize(new String(rs.getString("ship_size")))    
			.guestRating(new BigDecimal(rs.getString("guest_rating")))	
			.build();
		}});
	}


//	GET BY ID----------------------------------------------------------------------------
		
	@Override
	public List<Ships> getShipById(Long shipId) {
		
		String sql = ""
			+ "SELECT * "
			+ "FROM ships "
			+ "WHERE ship_id = :ship_id";
		
		Map<String, Long> params = new HashMap<>();			
			params.put("ship_id", shipId);		
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {  
	
	@Override
	public Ships mapRow(ResultSet rs, int rowNum) throws SQLException {
		return Ships.builder()
			.shipId(rs.getLong("ship_id"))							
			.shipName(new String(rs.getString("ship_name")))   
			.shipSize(new String(rs.getString("ship_size")))    
			.guestRating(new BigDecimal(rs.getString("guest_rating")))	
			.build();
		}});		
			
	}

//	POST---------------------------------------------------------------------------------------
		
	@Override
	public Optional<Ships> createShip(String shipName, String shipSize, BigDecimal guestRating) {	
		String sql = ""
		+ "INSERT INTO ships (" + "ship_name, ship_size, guest_rating"
		+ ") VALUES (" +  ":ship_name, :ship_size, :guest_rating)";
	
		Map<String, Object> params = new HashMap<>();				
		params.put("ship_name", shipName);					
		params.put("ship_size", shipSize);
		params.put("guest_rating", guestRating);
	
			jdbcTemplate.update(sql, params);
			return Optional.ofNullable(Ships.builder()
			.shipName(shipName).shipSize(shipSize).guestRating(guestRating).build());
	}
	
//	PUT---------------------------------------------------------------------------------------------
	
	@Override
	public Optional<Ships> updateShipDetails(Long shipId, String shipName, 
			String shipSize, BigDecimal guestRating, String newShipName, String newShipSize, BigDecimal newGuestRating) {
		
	
	String sql = ""
		+ "UPDATE ships SET ship_name = :new_ship_name, ship_size, = :new_ship_size, guest_rating = :new_guest_rating "
		+ "WHERE ship_id = :ship_id";
			
		Map<String, Object> params = new HashMap<>();
		params.put("ship_id", shipId);
		params.put("ship_name", shipName);
		params.put("ship_size", shipSize);
		params.put("guest_rating", guestRating);
		params.put("new_ship_name", newShipName);
		params.put("new_ship_size", newShipSize);
		params.put("new_guest_rating", newGuestRating);
	
			jdbcTemplate.update(sql, params);
			return Optional.ofNullable(Ships.builder()
			.shipId(shipId).shipName(newShipName).shipSize(newShipSize).guestRating(newGuestRating).build());
	}
	
//	DELETE---------------------------------------------------------------------------------------------
	
	@Override
	public Optional<Ships> deleteShip(Long shipId, String shipName) {    

		String sql = ""
			+ "DELETE FROM ships WHERE "
			+ "ship_id = :ship_id; AND ship_name = :ship_name";		

	
	Map<String, Object> params = new HashMap<>();				
	params.put("ship_id", shipId);					
	
	jdbcTemplate.update(sql, params);
	return Optional.ofNullable(Ships.builder().shipId(shipId).shipName(shipName).build());

	}
}

































