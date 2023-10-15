package com.br.hexagonal.adapters.inbound.mapper;

import com.br.hexagonal.application.domain.Developer;
import com.br.hexagonal.adapters.inbound.dto.request.DeveloperRequest;
import com.br.hexagonal.adapters.inbound.dto.response.DeveloperResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeveloperMapper {

    private final ModelMapper mapper;

    public Developer toDeveloperModel(DeveloperRequest developerRequest) {
        return mapper.map(developerRequest, Developer.class);
    }

    public DeveloperResponse toDeveloperResponse(Developer developer) {
        return mapper.map(developer, DeveloperResponse.class);
    }

}
