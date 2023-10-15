package com.br.hexagonal.adapters.inbound.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperRequest {

    @NotBlank
    private String nameDeveloper;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String positionLevel;
}
