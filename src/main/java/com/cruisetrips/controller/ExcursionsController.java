package com.cruisetrips.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cruisetrips.entity.Excursions;
import com.cruisetrips.entity.Ships;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Excursions")  
@OpenAPIDefinition(info = @Info(title = "Cruise Trips"), servers = {
@Server(url = "http://localhost:8080", description = "Local server.")})

public interface ExcursionsController {
	
//	GET ALL----------------------------------------------------------------

	@Operation(
		summary = "Returns a list of Excursions",
		description = "Returns a list of all Excursion Options", 
		responses = {
			@ApiResponse(
				responseCode = "200", 
				description = "A list of Excursions with details is returned",
				content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = Excursions.class))), 
			@ApiResponse(
				responseCode = "400", 
				description = "The request parameters are invalid", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404", 
				description = "No Excursions were found with the input criteria", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occured.", 
				content = @Content(mediaType = "application/json")),
	
		}
	)
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
		List<Excursions> getAllExcursions ();
	
//	GET BY ID----------------------------------------------------------------

	@Operation(
		summary = "Gets a specific Excursion by Id",
		description = "Gets the Excursion details using the Excursion ID", 
		responses = {
			@ApiResponse(
				responseCode = "200", 
				description = "An Excursion and its details are returned",
				content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = Ships.class))),
			@ApiResponse(
				responseCode = "400", 
				description = "The request parameters are invalid", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404", 
				description = "No Excursions were found with the input criteria", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occured.", 
				content = @Content(mediaType = "application/json")),
		},
			
		parameters = {
			@Parameter(
				name = "excursionId", 
				allowEmptyValue = false, 
				required = false, 
				description = "The Excursion ID (i.e., '6')"),	
		}
	)
	
	@GetMapping("/id")
	@ResponseStatus(code = HttpStatus.OK)
	List<Excursions> getExcursionById (Long excursionId);

//	POST----------------------------------------------------------------


	@Operation(
		summary = "Create a new Excursion",
		description = "Enter the Excursion name, exertion level, price per adult and price per child",
		responses = {
			@ApiResponse(
				responseCode = "201", 
				description = "A new Excursion has been created",
				content = @Content(
				mediaType = "application/json",
				schema = @Schema(implementation = Excursions.class))),
			@ApiResponse(
				responseCode = "400", 
				description = "The request parameters are invalid", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404", 
				description = "No Excursion has been created", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occured.", 
				content = @Content(mediaType = "application/json")),
		},
		
		parameters = {
			@Parameter(
				name = "excursionName", 
				allowEmptyValue = false, 
				required = false, 
				description = "The name of the new Excursion (i.e., 'Hiking')"),	
			@Parameter(
				name = "exertionLevel",
				allowEmptyValue = false,
				required = false,
				description = "The exertion level of the excursion activity (i.e. 'low, moderate, high')"),
			@Parameter(
				name = "adultPrice",
				allowEmptyValue = true,
				required = false, 
				description = "The price per adult (i.e. '100.00')"),
			@Parameter(
					name = "childPrice",
					allowEmptyValue = true,
					required = false, 
					description = "The price per adult (i.e. '50.00')"),
		}
	)
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Optional<Excursions> createExcursion(
		String excursionName,
		String exertionLevel,
		BigDecimal adultPrice,
		BigDecimal childPrice);
	
//	PUT----------------------------------------------------------------
	
	@Operation(
		summary = "Updates Excursion details",
		description = "Updates the details of the name, exertion level, price per adult, and/or price per child",
		responses = {
			@ApiResponse(
				responseCode = "200", 
				description = "The Excursion details have been updated",
				content = @Content(
				mediaType = "application/json",
				schema = @Schema(implementation = Excursions.class))),
			@ApiResponse(
				responseCode = "400", 
				description = "The request parameters are invalid", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404", 
				description = "No Excursions were found with the input criteria", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occured", 
				content = @Content(mediaType = "application/json")),
		},
		
		parameters = {
			@Parameter(
				name = "excursionId",
				allowEmptyValue = false, 
				required = false, 
				description = "The ID number of the Excursion (i.e. '10')"),
			@Parameter(
				name = "excursionName", 
				allowEmptyValue = false, 
				required = false, 
				description = "The name of the Excursion to be updated (i.e., 'Hiking')"),	
			@Parameter(
				name = "exertionLevel",
				allowEmptyValue = false,
				required = false,
				description = "The exertion level of the Excursion(i.e. 'low, moderate, high')"),
			@Parameter(
				name = "adultPrice",
				allowEmptyValue = true,
				required = false, 
				description = "The price of the Excursion per adult(i.e. '100.00')"),
			@Parameter(
				name = "childPrice", 
				allowEmptyValue = false, 
				required = false, 
				description = "The price of the Excursion per child (i.e. '50.00')"),	
			@Parameter(
				name = "newExcursionName", 
				allowEmptyValue = false, 
				required = false, 
				description = "The name of the new Excursion (i.e., 'Rock Climbing')"),	
			@Parameter(
				name = "newExertionLevel",
				allowEmptyValue = false,
				required = false,
				description = "The new exertion level of the Excursion(i.e. 'low, moderate, high')"),
			@Parameter(
				name = "newAdultPrice",
				allowEmptyValue = true,
				required = false, 
				description = "The new price of the Excursion per adult(i.e. '120.00')"),
			@Parameter(
				name = "newChildPrice", 
				allowEmptyValue = false, 
				required = false, 
				description = "The new price of the Excursion per child (i.e. '60.00')"),	
			
		}
	)
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
		Optional<Excursions> updateExcursionDetails(
			long excursionId, 
			String excursionName, 
			String exertionLevel, 
			BigDecimal adultPrice,
			BigDecimal childPrice,
			String newExcursionName,
			String newExertionLevel,
			BigDecimal newAdultPrice,
			BigDecimal newChildPrice);
	
	
//	DELETE---------------------------------------------------------------------------

	@Operation(
		summary = "Deletes an Excursion",
		description = "Deletes an Excursion and its details",
		responses = {
			@ApiResponse(
				responseCode = "200", 
				description = "An Excursion has been deleted",
				content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = Excursions.class))),
			@ApiResponse(
					responseCode = "400", 
					description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/json")),
			@ApiResponse(
					responseCode = "404", 
					description = "No Excursion has been deleted", 
					content = @Content(mediaType = "application/json")),
			@ApiResponse(
					responseCode = "500", 
					description = "An unplanned error occured.", 
					content = @Content(mediaType = "application/json")),
		},
		parameters = {
			@Parameter(
				name = "excursionId", 
				allowEmptyValue = false, 
				required = false, 
				description = "The ID number of the Excursion (i.e., '8')"),	
			@Parameter(
				name = "excursionName",
				allowEmptyValue = false,
				required = false,
				description = "The name of the Excursion (i.e. 'Hiking')"),
		}
	)	
		
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	Optional<Excursions> deleteExcursion(
		long excursionId, 
		String excursionName);		
}
