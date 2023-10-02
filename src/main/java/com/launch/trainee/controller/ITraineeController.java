package com.launch.trainee.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.launch.trainee.entity.Trainee;
import com.launch.trainee.entity.TraineeProfile;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/trainees")
@OpenAPIDefinition(info = @Info(title = "Launch Trainee Api"),
servers = {@Server(url = "http://localhost:8080", description = "Local Server.")})
public interface ITraineeController {
  
  
    @Operation( summary = "", description = "Returns Trainee Info", responses = {
    
    @ApiResponse( 
        responseCode = "200",
        description = "A list of Trainees are returned",
        content = @Content(mediaType = "application/json",
        schema = @Schema(implementation = Trainee.class))),
    
    @ApiResponse( responseCode = "400", 
        description = "The request parameters are invalid", 
        content = @Content(mediaType = "application/json")),
    
    @ApiResponse( responseCode = "404", 
        description = "No Trainees were found with the input criteria", 
        content = @Content(mediaType = "application/json")),
    
    @ApiResponse( responseCode = "500", description = "An unplanned error occured.", content
    = @Content(mediaType = "application/json")) }
    
    )
   


   @GetMapping("/fetchAllTrainees")
  @ResponseStatus(code = HttpStatus.OK)
   List<Trainee> fetchAllTrainees();

    @GetMapping("/{traineeId}/profile")
    @ResponseStatus(code = HttpStatus.OK)
    TraineeProfile getTraineeProfile(@PathVariable Integer traineeId);

}
