package com.br.hexagonal.adapters.inbound.mapper;

import com.br.hexagonal.adapters.inbound.dto.request.TaskRequest;
import com.br.hexagonal.adapters.inbound.dto.response.TaskResponse;
import com.br.hexagonal.adapters.outbound.entity.TaskEntity;
import com.br.hexagonal.application.domain.Task;
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

    public TaskResponse toTaskResponse(TaskEntity taskEntity) {
        return mapper.map(taskEntity, TaskResponse.class);
    }

    public TaskEntity taskToTaskEntity(Task task) {
        return mapper.map(task, TaskEntity.class);
    }

    public Task taskEntityToTask(TaskEntity taskEntity) {
        return mapper.map(taskEntity, Task.class);
    }
}
