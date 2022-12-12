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

import com.cruisetrips.entity.Itineraries;

	
@Component
@Service				

public class ItinerariesDaoImpl implements ItinerariesDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
		
		
//	GET ALL-----------------------------------------------------------------------------
		
	@Override
	public List<Itineraries> getAllItineraries() {
		
		String sql = ""
			+ "SELECT * "
			+ "FROM itineraries "; 
			
			return jdbcTemplate.query(sql, new RowMapper<Itineraries>() {
				
		@Override
		public Itineraries mapRow(ResultSet rs, int rowNum) throws SQLException {
			return Itineraries.builder()
				.itineraryId(rs.getLong("itinerary_id"))					
				.numberOfDays((rs.getInt("num_days")))   
				.numberOfPorts((rs.getInt("num_ports")))    
				.build();
			}});
		}	

//		GET BY ID----------------------------------------------------------------------------
			
		@Override
		public List<Itineraries> getItineraryById(Long itineraryId) {
			
			String sql = ""
				+ "SELECT * "
				+ "FROM ships "
				+ "WHERE ship_id = :ship_id";
			
			Map<String, Long> params = new HashMap<>();			
				params.put("ship_id", itineraryId);		
			
			return jdbcTemplate.query(sql, params, new RowMapper<>() {  
		
		@Override
		public Itineraries mapRow(ResultSet rs, int rowNum) throws SQLException {
			return Itineraries.builder()
				.itineraryId(rs.getLong("itinerary_id"))							
				.numberOfDays((rs.getInt("num_days")))   
				.numberOfPorts((rs.getInt("num_ports")))    
				.build();
			}});		
			
		}

//		POST---------------------------------------------------------------------------------------
			
		@Override
		public Optional<Itineraries> createItinerary(int numberOfDays, int numberOfPorts) {	
			String sql = ""
			+ "INSERT INTO itineraries (" + "num_days, num_ports"
			+ ") VALUES (" +  ":num_days, :num_ports)";
		
			Map<String, Object> params = new HashMap<>();	
			params.put("num_days", numberOfDays);					
			params.put("num_ports", numberOfPorts);
		
				jdbcTemplate.update(sql, params);
				return Optional.ofNullable(Itineraries.builder()
				.numberOfDays(numberOfDays).numberOfPorts(numberOfPorts).build());
		}
		
//		PUT---------------------------------------------------------------------------------------------
		
		@Override
		public Optional<Itineraries> updateItineraryDetails(Long itineraryId, int numberOfDays, 
				int numberOfPorts, int newNumberOfDays, int newNumberOfPorts) {
			
		
		String sql = ""
			+ "UPDATE itineraries SET num_days = :new_num_days, num_ports, = :new_num_ports  "
			+ "WHERE itinerary_id = :itinerary_id";
					
			Map<String, Object> params = new HashMap<>();
			params.put("itinerary_id", itineraryId);
			params.put("num_days", numberOfDays);
			params.put("num_ports", numberOfPorts);
			params.put("new_num_days", newNumberOfDays);
			params.put("new_num_ports", newNumberOfPorts);
		
				jdbcTemplate.update(sql, params);
				return Optional.ofNullable(Itineraries.builder()
				.itineraryId(itineraryId).numberOfDays(newNumberOfDays).numberOfPorts(newNumberOfPorts).build());
				
		}
		
//		DELETE---------------------------------------------------------------------------------------------
		
		@Override
		public Optional<Itineraries> deleteItinerary(Long itineraryId) {    

			String sql = ""
				+ "DELETE FROM itineraries WHERE "
				+ "itinerary_id = :itinerary_id";

		Map<String, Object> params = new HashMap<>();				
		params.put("itinerary_id", itineraryId);					
		
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Itineraries.builder().itineraryId(itineraryId).build());

		}
}
