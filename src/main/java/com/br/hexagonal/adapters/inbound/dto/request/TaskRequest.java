package com.br.hexagonal.adapters.inbound.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {

    @NotBlank
    @Schema(description = "Title Task", example = "Kafka topic correction")
    private String title;

    @NotBlank
    @Schema(description = "Description Task", example = "Change topic Kafka")
    private String description;

    @Future
    @Schema(description = "Deadline Task", example = "2023-10-30T19:26:55")
    private LocalDateTime deadline;
}
