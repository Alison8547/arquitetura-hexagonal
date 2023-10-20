package com.br.hexagonal.adapters.outbound;

import com.br.hexagonal.adapters.inbound.entity.TaskEntity;
import com.br.hexagonal.adapters.inbound.mapper.TaskMapper;
import com.br.hexagonal.adapters.outbound.repository.TaskRepository;
import com.br.hexagonal.application.domain.Task;
import com.br.hexagonal.application.ports.out.TaskFinishedPort;
import com.br.hexagonal.config.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Log4j2
@Component
@RequiredArgsConstructor
public class TaskFinishedAdapter implements TaskFinishedPort {

    private final TaskRepository taskRepository;
    private final TaskMapper mapper;
    private final GetTaskForDeveloperAdapter getTaskForDeveloperAdapter;
    private static final boolean FINISHED = false;

    @Override
    public Task finishedTask(UUID idTask) {
        TaskEntity taskEntity = getTaskForDeveloperAdapter.findTask(idTask);

        if (taskEntity.getDeveloper() == null)
            throw new BusinessException("Task cannot be completed because there is no one linked to it!");

        taskEntity.setStatus(FINISHED);
        taskRepository.save(taskEntity);
        log.info("Task finished Title: {}", taskEntity.getTitle());
        return mapper.taskEntityToTask(taskEntity);
    }
}
