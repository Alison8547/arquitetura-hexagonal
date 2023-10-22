package com.br.hexagonal.adapters.inbound.controller;

import com.br.hexagonal.adapters.inbound.dto.request.DeveloperRequest;
import com.br.hexagonal.adapters.inbound.dto.response.DeveloperResponse;
import com.br.hexagonal.adapters.inbound.mapper.DeveloperMapper;
import com.br.hexagonal.application.domain.Developer;
import com.br.hexagonal.application.ports.in.CreateDeveloperUserCasePort;
import com.br.hexagonal.application.ports.in.FindDeveloperUserCasePort;
import com.br.hexagonal.application.ports.in.UpdateDeveloperUserCasePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Validated
@RestController
@RequestMapping
@RequiredArgsConstructor
public class DeveloperController {

    private final CreateDeveloperUserCasePort createDeveloperPort;
    private final FindDeveloperUserCasePort findDeveloperUserCasePort;
    private final UpdateDeveloperUserCasePort updateDeveloperUserCasePort;
    private final DeveloperMapper mapper;

    @Operation(summary = "Create developer", description = "Save you developer to the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Successfully created"),
                    @ApiResponse(responseCode = "400", description = "An exception was generated"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource"),
                    @ApiResponse(responseCode = "500", description = "An internal server exception was generated")
            }
    )
    @PostMapping("/create-developer")
    public ResponseEntity<DeveloperResponse> createDeveloper(@Valid @RequestBody DeveloperRequest developerRequest) {
        Developer developer = mapper.toDeveloper(developerRequest);
        return new ResponseEntity<>(mapper.toDeveloperResponse(createDeveloperPort.createDeveloper(developer)), HttpStatus.CREATED);
    }

    @Operation(summary = "Find Developer", description = "Search for developer in the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Search successfully"),
                    @ApiResponse(responseCode = "400", description = "An exception was generated"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource"),
                    @ApiResponse(responseCode = "500", description = "An internal server exception was generated")
            }
    )
    @GetMapping("/find-developer/{id}")
    public ResponseEntity<DeveloperResponse> findDeveloper(@PathVariable(name = "id") UUID id) {
        Optional<Developer> developer = findDeveloperUserCasePort.findDeveloper(id);
        return developer.map(value -> new ResponseEntity<>(mapper.toDeveloperResponse(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Update Developer", description = "Update developer in the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Edited successfully"),
                    @ApiResponse(responseCode = "400", description = "An exception was generated"),
                    @ApiResponse(responseCode = "403", description = "You do not have permission to access this resource"),
                    @ApiResponse(responseCode = "500", description = "An internal server exception was generated")
            }
    )
    @PutMapping("/update-developer/{id}")
    public ResponseEntity<DeveloperResponse> updateDeveloper(@PathVariable(name = "id") UUID id, @RequestBody @Valid DeveloperRequest developerRequest) {
        Developer developer = mapper.toDeveloper(developerRequest);
        return new ResponseEntity<>(mapper.toDeveloperResponse(updateDeveloperUserCasePort.updateDeveloper(id, developer)), HttpStatus.OK);
    }

}
