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

import com.cruisetrips.entity.Ports;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

	
	@Validated
	@RequestMapping("/Ports")  
	@OpenAPIDefinition(info = @Info(title = "Cruise Trips"), servers = {
	@Server(url = "http://localhost:8080", description = "Local server.")})

public interface PortsController {
		
//		GET ALL----------------------------------------------------------------

		@Operation(
			summary = "Returns a list of ports",
			description = "Returns a list of all ports", 
			responses = {
				@ApiResponse(
					responseCode = "200", 
					description = "A list of Ports is returned",
					content = @Content(mediaType = "application/json",
					schema = @Schema(implementation = Ports.class))), 
				@ApiResponse(
					responseCode = "400", 
					description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/json")),
				@ApiResponse(
					responseCode = "404", 
					description = "No Ports were found with the input criteria", 
					content = @Content(mediaType = "application/json")),
				@ApiResponse(
					responseCode = "500", 
					description = "An unplanned error occured.", 
					content = @Content(mediaType = "application/json")),
		
			}
			
		)
		
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
			List<Ports> getAllPorts ();
		
//		GET BY ID----------------------------------------------------------------

		@Operation(
			summary = "Gets a specific port by Id",
			description = "Gets the port and location details using the port id", 
			responses = {
				@ApiResponse(
					responseCode = "200", 
					description = "A port and its location are returned",
					content = @Content(mediaType = "application/json",
						schema = @Schema(implementation = Ports.class))),
				@ApiResponse(
					responseCode = "400", 
					description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/json")),
				@ApiResponse(
					responseCode = "404", 
					description = "No Ports were found with the input criteria", 
					content = @Content(mediaType = "application/json")),
				@ApiResponse(
					responseCode = "500", 
					description = "An unplanned error occured.", 
					content = @Content(mediaType = "application/json")),
			},
				
			parameters = {
				@Parameter(
					name = "portId", 
					allowEmptyValue = false, 
					required = false, 
					description = "The portId (i.e., '10')"),	
			}
		)
		
		@GetMapping("/id")
		@ResponseStatus(code = HttpStatus.OK)
		List<Ports> getPortById (Long portId);

//		POST----------------------------------------------------------------


		@Operation(
			summary = "Create a new Port",
			description = "Enter the abbreviation and location of the Port",
			responses = {
				@ApiResponse(
					responseCode = "201", 
					description = "A new Port has been created",
					content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = Ports.class))),
				@ApiResponse(
					responseCode = "400", 
					description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/json")),
				@ApiResponse(
					responseCode = "404", 
					description = "No Port has been created", 
					content = @Content(mediaType = "application/json")),
				@ApiResponse(
					responseCode = "500", 
					description = "An unplanned error occured.", 
					content = @Content(mediaType = "application/json")),
			},
			parameters = {
				@Parameter(
					name = "PortAbbr", 
					allowEmptyValue = false, 
					required = false, 
					description = "The abbreviation for the new Port (i.e., 'COZ')"),	
				@Parameter(
					name = "PortLocation",
					allowEmptyValue = false,
					required = false,
					description = "The location of the Port (i.e. 'Cozumel')"),
			}
		)
		
		@PostMapping
		@ResponseStatus(code = HttpStatus.CREATED)
		Optional<Ports> createPort(
			String portAbbr,
			String portLocation);
		
//		PUT----------------------------------------------------------------
		
		@Operation(
			summary = "Updates Port details",
			description = "Updates the details of the Port ID and location",
			responses = {
				@ApiResponse(
					responseCode = "200", 
					description = "The Port details have been updated",
					content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = Ports.class))),
				@ApiResponse(
					responseCode = "400", 
					description = "The request parameters are invalid", 
					content = @Content(mediaType = "application/json")),
				@ApiResponse(
					responseCode = "404", 
					description = "No Ports were found with the input criteria", 
					content = @Content(mediaType = "application/json")),
				@ApiResponse(
					responseCode = "500", 
					description = "An unplanned error occured.", 
					content = @Content(mediaType = "application/json")),
			},
		
					parameters = {
							@Parameter(
								name = "portId", 
								allowEmptyValue = false, 
								required = false, 
								description = "The ID of the Port (i.e., '10')"),	
							@Parameter(
								name = "portAbbr",
								allowEmptyValue = false,
								required = false, 
								description = "The abbreviation for the Port (i.e., 'COZ')"),
							@Parameter(
								name = "portLocation",
								allowEmptyValue = false,
								required = false,
								description = "The location of Port (i.e. 'Cozumel, Mexico')"),
							@Parameter(
								name = "newPortAbbr", 
								allowEmptyValue = false, 
								required = false, 
								description = "The new abbreviation for the Port (i.e., 'ROT')"),	
							@Parameter(
								name = "newPortLocation",
								allowEmptyValue = false,
								required = false,
								description = "The location of the new Port (i.e. 'Roaton, Honduras')"),
			}
		)
		
		@PutMapping
		@ResponseStatus(code = HttpStatus.OK)
			Optional<Ports> updatePortDetails(
				Long portId, 
				String portAbbr,
				String portLocation,
				String newPortAbbr,
				String newPortLocation);
				
//		DELETE---------------------------------------------------------------------------

		@Operation(
			summary = "Deletes a Port",
			description = "Deletes a Port and its location",
			responses = {
				@ApiResponse(
					responseCode = "200", 
					description = "A Port has been deleted",
					content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = Ports.class))),
				@ApiResponse(
						responseCode = "400", 
						description = "The request parameters are invalid", 
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "404", 
						description = "No Port has been deleted", 
						content = @Content(mediaType = "application/json")),
				@ApiResponse(
						responseCode = "500", 
						description = "An unplanned error occured.", 
						content = @Content(mediaType = "application/json")),
			},
			parameters = {
				@Parameter(
					name = "portId", 
					allowEmptyValue = false, 
					required = false, 
					description = "The ID of the Port (i.e., '8')"),	
				@Parameter(
					name = "portAbbr",
					allowEmptyValue = false,
					required = false,
					description = "The abbreviation for the port (i.e., COZ')"),
			}
		)	
			
		@DeleteMapping
		@ResponseStatus(code = HttpStatus.OK)
		Optional<Ports> deletePort(
			Long portId, 
			String portAbbr);
}
