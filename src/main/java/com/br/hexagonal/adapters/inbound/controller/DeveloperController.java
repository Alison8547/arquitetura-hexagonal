package com.br.hexagonal.adapters.inbound.controller;

import com.br.hexagonal.adapters.inbound.dto.request.DeveloperRequest;
import com.br.hexagonal.adapters.inbound.dto.response.DeveloperResponse;
import com.br.hexagonal.adapters.inbound.mapper.DeveloperMapper;
import com.br.hexagonal.application.domain.Developer;
import com.br.hexagonal.application.ports.in.CreateDeveloperUserCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping
@RequiredArgsConstructor
public class DeveloperController {

    private final CreateDeveloperUserCasePort createDeveloperPort;
    private final DeveloperMapper mapper;

    @PostMapping("/create-developer")
    public ResponseEntity<DeveloperResponse> createDeveloper(@Valid @RequestBody DeveloperRequest developerRequest) {
        Developer developer = mapper.toDeveloper(developerRequest);
        return new ResponseEntity<>(mapper.toDeveloperResponse(createDeveloperPort.createDeveloper(developer)), HttpStatus.CREATED);
    }

}
