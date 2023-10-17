package com.br.hexagonal.adapters.outbound;

import com.br.hexagonal.adapters.inbound.entity.DeveloperEntity;
import com.br.hexagonal.adapters.inbound.entity.TaskEntity;
import com.br.hexagonal.adapters.inbound.mapper.TaskMapper;
import com.br.hexagonal.adapters.outbound.repository.TaskRepository;
import com.br.hexagonal.application.domain.Task;
import com.br.hexagonal.application.ports.out.GetTaskForDeveloperPort;
import com.br.hexagonal.config.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Log4j2
@Component
@RequiredArgsConstructor
public class GetTaskForDeveloperAdapter implements GetTaskForDeveloperPort {

    private final TaskRepository taskRepository;
    private final TaskMapper mapper;
    private final FindDeveloperAdapter findDeveloperAdapter;


    @Override
    public Task getTaskForDeveloper(String emailDev, UUID idTask) {
        DeveloperEntity devEntity = findDeveloperAdapter.findDevEmail(emailDev);
        TaskEntity taskEntity = findTask(idTask);
        taskEntity.setIdDeveloper(devEntity.getId());
        taskEntity.setDeveloper(devEntity);
        taskRepository.save(taskEntity);
        log.info("Developer {} got the task: {}", devEntity.getNameDeveloper(), taskEntity.getTitle());

        return mapper.taskEntityToTask(taskEntity);
    }


    public TaskEntity findTask(UUID id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Task not found!"));
    }
}
