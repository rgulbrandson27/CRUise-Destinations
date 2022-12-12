package com.cruisetrips.dao;

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

import com.cruisetrips.entity.Excursions;

@Component
@Service

public class ExcursionsDaoImpl implements ExcursionsDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	
//	GET ALL-----------------------------------------------------------------------------
	
	@Override
	public List<Excursions> getAllExcursions() {
	
		String sql = ""
			+ "SELECT * "
			+ "FROM excursions "; 
		
		return jdbcTemplate.query(sql, new RowMapper<Excursions>() {
			
	@Override
	public Excursions mapRow(ResultSet rs, int rowNum) throws SQLException {
		return Excursions.builder()
			.excursionId(rs.getLong("excursion_id"))					
			.excursionName(new String(rs.getString("excursion_name")))   
			.exertionLevel(new String(rs.getString("exertion_level")))    
			.adultPrice(new BigDecimal(rs.getString("adult_price")))	
			.childPrice(new BigDecimal(rs.getString("child_price")))	
			.build();
		}});
	}

//	GET BY ID----------------------------------------------------------------
	
	@Override
	public List<Excursions> getExcursionById(Long excursionId) {
		
		String sql = ""
			+ "SELECT * "
			+ "FROM excursions "
			+ "WHERE excursion_id = :excursion_id";
		
		Map<String, Long> params = new HashMap<>();			
			params.put("excursion_id", excursionId);		
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {  
	
	@Override
	public Excursions mapRow(ResultSet rs, int rowNum) throws SQLException {
		return Excursions.builder()
			.excursionId(rs.getLong("excursion_id"))					
			.excursionName(new String(rs.getString("excursion_name")))   
			.exertionLevel(new String(rs.getString("exertion_level")))    
			.adultPrice(new BigDecimal(rs.getString("adult_price")))	
			.childPrice(new BigDecimal(rs.getString("child_price")))	
			.build();
		}});		
	}

//	POST---------------------------------------------------------------------------------------
	
	@Override
	public Optional<Excursions> createExcursion(String excursionName, String exertionLevel, BigDecimal adultPrice,
			BigDecimal childPrice) {
		String sql = ""
		+ "INSERT INTO excursions (" + "excursion_name, exertionLevel, adultPrice, childPrice"
		+ ") VALUES (" +  ":excursion_name, :exertion_level, :adult_price, :child_price)";
	
		Map<String, Object> params = new HashMap<>();				
		params.put("excursion_name", excursionName);					
		params.put("exertion_level", exertionLevel);
		params.put("adult_price", adultPrice);
		params.put("child_price", childPrice);

	
			jdbcTemplate.update(sql, params);
			return Optional.ofNullable(Excursions.builder()
			.excursionName(excursionName).exertionLevel(exertionLevel).adultPrice(adultPrice).childPrice(childPrice).build());
	}
	
//	PUT---------------------------------------------------------------------------------------------

	@Override
	public Optional<Excursions> updateExcursionDetails(Long excursionId, String excursionName, String exertionLevel,
			BigDecimal adultPrice, BigDecimal childPrice, String newExcursionName, String newExertionLevel,
			BigDecimal newAdultPrice, BigDecimal newChildPrice) {
	
	String sql = ""
		+ "UPDATE ships SET ship_name = :new_ship_name, ship_size, = :new_ship_size, guest_rating = :new_guest_rating "
		+ "WHERE ship_id = :ship_id";
			
		Map<String, Object> params = new HashMap<>();
		params.put("excursion_id", excursionId);
		params.put("excursion_name", excursionName);					
		params.put("exertion_level", exertionLevel);
		params.put("adult_price", adultPrice);
		params.put("child_price", childPrice);
		params.put("new_excursion_name", newExcursionName);					
		params.put("new_exertion_level", newExertionLevel);
		params.put("new_adult_price", newAdultPrice);
		params.put("new_child_price", newChildPrice);

	
			jdbcTemplate.update(sql, params);
			return Optional.ofNullable(Excursions.builder()
			.excursionId(excursionId).excursionName(newExcursionName).exertionLevel(newExertionLevel).adultPrice(newAdultPrice).childPrice(newChildPrice).build());
	}

//	DELETE---------------------------------------------------------------------------------------------
	
	@Override
	public Optional<Excursions> deleteExcursion(Long excursionId, String excursionName) {    

		String sql = ""
			+ "DELETE FROM excursions WHERE "
			+ "excursion_id = :excursion_id; AND excursion_name = :excursion_name";		

	
	Map<String, Object> params = new HashMap<>();				
	params.put("excursion_id", excursionId);					
	
	jdbcTemplate.update(sql, params);
	return Optional.ofNullable(Excursions.builder().excursionId(excursionId).excursionName(excursionName).build());

	}
}











