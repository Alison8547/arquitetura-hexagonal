package com.br.hexagonal.builders;

import com.br.hexagonal.adapters.inbound.dto.request.DeveloperRequest;
import com.br.hexagonal.adapters.inbound.dto.response.DeveloperResponse;
import com.br.hexagonal.adapters.inbound.entity.DeveloperEntity;

import java.util.UUID;

public class DeveloperBuilder {

    public static DeveloperEntity newDeveloperEntity() {
        return DeveloperEntity.builder()
                .id(UUID.randomUUID())
                .nameDeveloper("Alison")
                .email("alison@hotmail.com")
                .positionLevel("Junior")
                .build();
    }

    public static DeveloperRequest newDeveloperRequest() {
        return DeveloperRequest.builder()
                .nameDeveloper("Alison")
                .email("alison@hotmail.com")
                .positionLevel("Junior")
                .build();

    }

    public static DeveloperResponse newDeveloperResponse() {
        return DeveloperResponse.builder()
                .id(UUID.randomUUID())
                .nameDeveloper("Alison")
                .email("alison@hotmail.com")
                .positionLevel("Junior")
                .build();
    }
}
