package com.br.hexagonal.adapters.inbound.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "You name", example = "Alison")
    private String nameDeveloper;

    @NotBlank
    @Email
    @Schema(description = "You email", example = "alison@hotmail.com")
    private String email;

    @NotBlank
    @Schema(description = "You position level", example = "Junior")
    private String positionLevel;
}
