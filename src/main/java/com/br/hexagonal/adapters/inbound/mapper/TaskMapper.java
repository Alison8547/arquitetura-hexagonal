package com.br.hexagonal.adapters.inbound.mapper;

import com.br.hexagonal.adapters.inbound.dto.request.TaskRequest;
import com.br.hexagonal.adapters.inbound.dto.response.TaskResponse;
import com.br.hexagonal.adapters.outbound.entity.TaskEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final ModelMapper mapper;

    public TaskEntity toTaskModel(TaskRequest taskRequest) {
        return mapper.map(taskRequest, TaskEntity.class);
    }

    public TaskResponse toTaskResponse(TaskEntity task) {
        return mapper.map(task, TaskResponse.class);
    }
}
