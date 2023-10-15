package com.br.hexagonal.adapters.inbound.mapper;

import com.br.hexagonal.adapters.inbound.dto.request.DeveloperRequest;
import com.br.hexagonal.adapters.inbound.dto.response.DeveloperResponse;
import com.br.hexagonal.adapters.outbound.entity.DeveloperEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeveloperMapper {

    private final ModelMapper mapper;

    public DeveloperEntity toDeveloperModel(DeveloperRequest developerRequest) {
        return mapper.map(developerRequest, DeveloperEntity.class);
    }

    public DeveloperResponse toDeveloperResponse(DeveloperEntity developer) {
        return mapper.map(developer, DeveloperResponse.class);
    }

}
