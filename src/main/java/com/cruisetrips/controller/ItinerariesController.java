package com.cruisetrips.controller;

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

import com.cruisetrips.entity.Itineraries;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Itineraries")  
@OpenAPIDefinition(info = @Info(title = "Cruise Trips"), servers = {
@Server(url = "http://localhost:8080", description = "Local server.")})


public interface ItinerariesController {

	
//	GET ALL----------------------------------------------------------------

	@Operation(
		summary = "Returns a list of itineraries",
		description = "Returns a list of all itineraries", 
		responses = {
			@ApiResponse(
				responseCode = "200", 
				description = "A list of Itineraries is returned",
				content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = Itineraries.class))), 
			@ApiResponse(
				responseCode = "400", 
				description = "The request parameters are invalid", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404", 
				description = "No Itineraries were found with the input criteria", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occured.", 
				content = @Content(mediaType = "application/json")),
	
		}
	)
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
		List<Itineraries> getAllItineraries ();
	
//	GET BY ID----------------------------------------------------------------

	@Operation(
		summary = "Gets a specific Itinerary by Id",
		description = "Gets the Itinerary details using the Itinerary Id", 
		responses = {
			@ApiResponse(
				responseCode = "200", 
				description = "An Itinerary and its details are returned",
				content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = Itineraries.class))),
			@ApiResponse(
				responseCode = "400", 
				description = "The request parameters are invalid", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404", 
				description = "No Itineraries were found with the input criteria", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occured.", 
				content = @Content(mediaType = "application/json")),
		},
			
		parameters = {
			@Parameter(
				name = "itineraryId", 
				allowEmptyValue = false, 
				required = false, 
				description = "The itineraryId (i.e., '14')"),	
		}
	)
	
	@GetMapping("/id")
	@ResponseStatus(code = HttpStatus.OK)
	List<Itineraries> getItineraryById (Long itineraryId);

//	POST----------------------------------------------------------------

	@Operation(
		summary = "Create a new Itinerary",
		description = "Enter the number of days and number of ports for the itinerary",
		responses = {
			@ApiResponse(
				responseCode = "201", 
				description = "A new Itinerary has been created",
				content = @Content(
				mediaType = "application/json",
				schema = @Schema(implementation = Itineraries.class))),
			@ApiResponse(
				responseCode = "400", 
				description = "The request parameters are invalid", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404", 
				description = "No Itinerary has been created", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occured.", 
				content = @Content(mediaType = "application/json")),
		},
		
		parameters = {
			@Parameter(
				name = "numberOfDays", 
				allowEmptyValue = false, 
				required = false, 
				description = "The lenth of the trip in days(i.e., '5')"),	
			@Parameter(
				name = "numberOfPorts",
				allowEmptyValue = false,
				required = false,
				description = "The number of port calls (i.e. '3')"),
		}
	)
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Optional<Itineraries> createItinerary(
		int numberOfDays,
		int numberOfPorts);
	
	
//	PUT----------------------------------------------------------------
	
	@Operation(
		summary = "Updates Itinerary details",
		description = "Updates the details of Itinerary including the trip length and port calls",
		responses = {
			@ApiResponse(
				responseCode = "200", 
				description = "The Itinerary details have been updated",
				content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = Itineraries.class))),
			@ApiResponse(
				responseCode = "400", 
				description = "The request parameters are invalid", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404", 
				description = "No Itineraries were found with the input criteria", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occured.", 
				content = @Content(mediaType = "application/json")),
		},
		
		parameters = {
			@Parameter(
				name = "itineraryId", 
				allowEmptyValue = false, 
				required = false, 
				description = "The itineraryId (i.e., '14')"),		
			@Parameter(
				name = "numberOfDays", 
				allowEmptyValue = false, 
				required = false, 
				description = "The lenth of the trip in days(i.e., '5')"),	
			@Parameter(					
				name = "numberOfPorts",
				allowEmptyValue = false,
				required = false,
				description = "The number of port calls (i.e. '3')"),
			@Parameter(
				name = "newNumberOfDays", 
				allowEmptyValue = false, 
				required = false, 
				description = "The new lenth of the trip in days(i.e., '7')"),	
			@Parameter(
				name = "newNumberOfPorts",
				allowEmptyValue = false,
				required = false,
				description = "The new number of port calls(i.e. '4')"),
		}
	)
		
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
		Optional<Itineraries> updateItineraryDetails(
			long itineraryId, 
			int numberOfDays, 
			int numberOfPorts,
			int newNumberOfDays,
			int newNumberOfPorts);
			
//	DELETE---------------------------------------------------------------------------

	@Operation(
		summary = "Deletes an Itinerary",
		description = "Deletes an Itinerary and all of its details",
		responses = {
			@ApiResponse(
				responseCode = "200", 
				description = "An Itinerary has been deleted",
				content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = Itineraries.class))),
			@ApiResponse(
					responseCode = "400", 
					description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/json")),
			@ApiResponse(
					responseCode = "404", 
					description = "No Itinerary has been deleted", 
					content = @Content(mediaType = "application/json")),
			@ApiResponse(
					responseCode = "500", 
					description = "An unplanned error occured.", 
					content = @Content(mediaType = "application/json")),
		},
		parameters = {
			@Parameter(
				name = "itineraryId", 
				allowEmptyValue = false, 
				required = false, 
				description = "The ID number of the Itinerary (i.e., '14')"),	
		}
	)	
		
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	Optional<Itineraries> deleteItinerary(
		long itineraryId);			
}

