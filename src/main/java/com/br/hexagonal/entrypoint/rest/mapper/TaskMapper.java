package com.br.hexagonal.entrypoint.rest.mapper;

import com.br.hexagonal.application.domain.Task;
import com.br.hexagonal.entrypoint.rest.dto.request.TaskRequest;
import com.br.hexagonal.entrypoint.rest.dto.response.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final ModelMapper mapper;

    public Task toTaskModel(TaskRequest taskRequest) {
        return mapper.map(taskRequest, Task.class);
    }

    public TaskResponse toTaskResponse(Task task) {
        return mapper.map(task, TaskResponse.class);
    }
}
