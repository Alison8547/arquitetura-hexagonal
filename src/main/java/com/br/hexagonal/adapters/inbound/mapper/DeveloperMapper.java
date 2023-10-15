package com.br.hexagonal.adapters.inbound.mapper;

import com.br.hexagonal.adapters.inbound.dto.request.DeveloperRequest;
import com.br.hexagonal.adapters.inbound.dto.response.DeveloperResponse;
import com.br.hexagonal.adapters.inbound.entity.DeveloperEntity;
import com.br.hexagonal.application.domain.Developer;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeveloperMapper {

    private final ModelMapper mapper;

    public DeveloperEntity toDeveloperEntity(DeveloperRequest developerRequest) {
        return mapper.map(developerRequest, DeveloperEntity.class);
    }

    public Developer toDeveloper(DeveloperRequest developerRequest) {
        return mapper.map(developerRequest, Developer.class);
    }

    public DeveloperResponse toDeveloperResponse(Developer developer) {
        return mapper.map(developer, DeveloperResponse.class);
    }

    public DeveloperEntity developerToDeveloperEntity(Developer developer) {
        return mapper.map(developer, DeveloperEntity.class);
    }

    public Developer developerEntityToDeveloper(DeveloperEntity developerEntity) {
        return mapper.map(developerEntity, Developer.class);
    }

}
