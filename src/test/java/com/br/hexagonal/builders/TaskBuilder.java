package com.br.hexagonal.builders;

import com.br.hexagonal.adapters.inbound.dto.request.TaskRequest;
import com.br.hexagonal.adapters.inbound.dto.response.TaskResponse;
import com.br.hexagonal.adapters.inbound.entity.TaskEntity;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.UUID;

public class TaskBuilder {

    public static TaskEntity newTaskEntityBuilder() {
        return TaskEntity.builder()
                .id(UUID.randomUUID())
                .title("Fix Kafka")
                .description("Fix Kafka topic")
                .timeOpen(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))
                .deadline(LocalDateTime.of(2024, Month.MAY, 11, 12, 44, 32))
                .status(true)
                .idDeveloper(DeveloperBuilder.newDeveloperEntity().getId())
                .developer(DeveloperBuilder.newDeveloperEntity())
                .build();
    }

    public static TaskRequest newTaskRequestBuilder() {
        return TaskRequest.builder()
                .title("Fix Kafka")
                .description("Fix Kafka topic")
                .deadline(LocalDateTime.of(2024, Month.MAY, 11, 12, 44, 32))
                .build();
    }

    public static TaskResponse newTaskResponseBuilder() {
        return TaskResponse.builder()
                .id(UUID.randomUUID())
                .title("Fix Kafka")
                .description("Fix Kafka topic")
                .timeOpen(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")))
                .deadline(LocalDateTime.of(2024, Month.MAY, 11, 12, 44, 32))
                .status(true)
                .build();

    }
}
