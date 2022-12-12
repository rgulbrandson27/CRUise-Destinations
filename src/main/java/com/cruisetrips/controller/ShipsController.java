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
@RequestMapping("/Ships")  
@OpenAPIDefinition(info = @Info(title = "Cruise Trips"), servers = {
@Server(url = "http://localhost:8080", description = "Local server.")})

public interface ShipsController {
	
//	GET ALL----------------------------------------------------------------

	@Operation(
		summary = "Returns a list of ships",
		description = "Returns a list of all ships", 
		responses = {
			@ApiResponse(
				responseCode = "200", 
				description = "A list of Ships is returned",
				content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = Ships.class))), 
			@ApiResponse(
				responseCode = "400", 
				description = "The request parameters are invalid", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404", 
				description = "No Ships were found with the input criteria", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occured.", 
				content = @Content(mediaType = "application/json")),

		}
	)
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
		List<Ships> getAllShips ();
			

	
//	GET BY ID----------------------------------------------------------------

	@Operation(
		summary = "Gets a specific ship by Id",
		description = "Gets the ship details using the ship id", 
		responses = {
			@ApiResponse(
				responseCode = "200", 
				description = "A ship and its details are returned",
				content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = Ships.class))),
			@ApiResponse(
				responseCode = "400", 
				description = "The request parameters are invalid", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404", 
				description = "No Ships were found with the input criteria", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occured.", 
				content = @Content(mediaType = "application/json")),
		},
			
		parameters = {
			@Parameter(
				name = "shipId", 
				allowEmptyValue = false, 
				required = false, 
				description = "The shipId (i.e., '6')"),	
		}
	)
	
	@GetMapping("/id")
	@ResponseStatus(code = HttpStatus.OK)
	List<Ships> getShipById (Long shipId);

//	POST----------------------------------------------------------------


	@Operation(
		summary = "Create a new Ship",
		description = "Enter the name, size and guest rating of the ship",
		responses = {
			@ApiResponse(
				responseCode = "201", 
				description = "A new Ship has been created",
				content = @Content(
				mediaType = "application/json",
				schema = @Schema(implementation = Ships.class))),
			@ApiResponse(
				responseCode = "400", 
				description = "The request parameters are invalid", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404", 
				description = "No Ship has been created", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occured.", 
				content = @Content(mediaType = "application/json")),
		},
		
		parameters = {
			@Parameter(
				name = "shipName", 
				allowEmptyValue = false, 
				required = false, 
				description = "The name of the new Ship (i.e., 'Lady of the Sea')"),	
			@Parameter(
				name = "shipSize",
				allowEmptyValue = false,
				required = false,
				description = "The size/occupancy of the Ship (i.e. '2,500')"),
			@Parameter(
				name = "guestRating",
				allowEmptyValue = true,
				required = false, 
				description = "The star guest rating of the ship (i.e. '4.7')"),
		}
	)
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Optional<Ships> createShip(
		String shipName,
		String shipSize,
		BigDecimal guestRating);
	
//	PUT----------------------------------------------------------------
	
	@Operation(
		summary = "Updates ship details",
		description = "Updates the details of the name, size, and/or guest rating of a ship",
		responses = {
			@ApiResponse(
				responseCode = "200", 
				description = "The ship details have been updated",
				content = @Content(
				mediaType = "application/json",
				schema = @Schema(implementation = Ships.class))),
			@ApiResponse(
				responseCode = "400", 
				description = "The request parameters are invalid", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "404", 
				description = "No Ships were found with the input criteria", 
				content = @Content(mediaType = "application/json")),
			@ApiResponse(
				responseCode = "500", 
				description = "An unplanned error occured", 
				content = @Content(mediaType = "application/json")),
		},
		
		parameters = {
			@Parameter(
				name = "shipId",
				allowEmptyValue = false, 
				required = false, 
				description = "The number ID of the Ship (i.e. '8')"),
			@Parameter(
				name = "shipName", 
				allowEmptyValue = false, 
				required = false, 
				description = "The name of the Ship to be updated (i.e., 'Lady of the Sea')"),	
			@Parameter(
				name = "shipSize",
				allowEmptyValue = false,
				required = false,
				description = "The size/occupancy of the Ship (i.e. '2,500')"),
			@Parameter(
				name = "guestRating",
				allowEmptyValue = true,
				required = false, 
				description = "The star guest rating of the ship (i.e. '4.7')"),
			@Parameter(
				name = "newShipName", 
				allowEmptyValue = false, 
				required = false, 
				description = "The name of the new Ship (i.e., 'Lady of the Ocean')"),	
			@Parameter(
				name = "newShipSize",
				allowEmptyValue = false,
				required = false,
				description = "The size/occupancy of the Ship (i.e. '3,000')"),
			@Parameter(
				name = "newGuestRating",
				allowEmptyValue = true,
				required = false, 
				description = "The star guest rating of the ship (i.e. '4.8')"),
		}
	)
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
		Optional<Ships> updateShipDetails(
			long shipId, 
			String shipName, 
			String shipSize, 
			BigDecimal guestRating,
			String newShipName,
			String newShipSize,
			BigDecimal newGuestRating);
	
	
//	DELETE---------------------------------------------------------------------------

	@Operation(
		summary = "Deletes a Ship",
		description = "Deletes a Ship and all of its attributes",
		responses = {
			@ApiResponse(
				responseCode = "200", 
				description = "A Ship has been deleted",
				content = @Content(mediaType = "application/json",
				schema = @Schema(implementation = Ships.class))),
			@ApiResponse(
					responseCode = "400", 
					description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/json")),
			@ApiResponse(
					responseCode = "404", 
					description = "No Ship has been deleted", 
					content = @Content(mediaType = "application/json")),
			@ApiResponse(
					responseCode = "500", 
					description = "An unplanned error occured.", 
					content = @Content(mediaType = "application/json")),
		},
		parameters = {
			@Parameter(
				name = "shipId", 
				allowEmptyValue = false, 
				required = false, 
				description = "The ID number of the Shipname of the new Ship (i.e., '8')"),	
			@Parameter(
				name = "shipName",
				allowEmptyValue = false,
				required = false,
				description = "The name of the Ship (i.e. 'Lady of the Seas')"),
		}
	)	
		
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	Optional<Ships> deleteShip(
		long shipId, 
		String shipName);		
}



