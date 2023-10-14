package com.br.hexagonal.entrypoint.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperResponse {

    private UUID id;
    private String nameDeveloper;
    private String email;
    private String positionLevel;

}
