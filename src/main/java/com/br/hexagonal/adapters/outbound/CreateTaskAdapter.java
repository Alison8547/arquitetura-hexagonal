package com.br.hexagonal.adapters.outbound;

import com.br.hexagonal.adapters.inbound.entity.TaskEntity;
import com.br.hexagonal.adapters.inbound.mapper.TaskMapper;
import com.br.hexagonal.adapters.outbound.repository.TaskRepository;
import com.br.hexagonal.application.domain.Task;
import com.br.hexagonal.application.ports.out.CreateTaskPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Log4j2
@Component
@RequiredArgsConstructor
public class CreateTaskAdapter implements CreateTaskPort {

    private final TaskRepository taskRepository;
    private final TaskMapper mapper;
    private static final boolean DEFAULT_OPEN_TASK = true;

    @Override
    public Task createTask(Task task) {
        TaskEntity taskEntity = mapper.taskToTaskEntity(task);
        taskEntity.setTimeOpen(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        taskEntity.setStatus(DEFAULT_OPEN_TASK);
        taskRepository.save(taskEntity);
        log.info("Task created success!");

        return mapper.taskEntityToTask(taskEntity);

    }
}
