package com.br.hexagonal.adapters.outbound;

import com.br.hexagonal.adapters.inbound.entity.DeveloperEntity;
import com.br.hexagonal.adapters.inbound.entity.TaskEntity;
import com.br.hexagonal.adapters.inbound.mapper.TaskMapper;
import com.br.hexagonal.adapters.outbound.repository.TaskRepository;
import com.br.hexagonal.application.domain.Task;
import com.br.hexagonal.application.ports.out.JoinDevTaskPort;
import com.br.hexagonal.config.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Component
public class JoinDevTaskAdapter implements JoinDevTaskPort {

    private final TaskRepository taskRepository;
    private final TaskMapper mapper;
    private final FindDeveloperAdapter findDeveloperAdapter;

    @Override
    public Task joinDevTask(UUID idDev, UUID idTask) {
        DeveloperEntity devFind = findDeveloperAdapter.findDeveloperDB(idDev);
        TaskEntity taskFind = findTaskDB(idTask);

        if (!taskFind.getStatus()) {
            throw new BusinessException("Task finished not possible join dev!");
        }

        if (taskFind.getDeveloper() != null) {
            throw new BusinessException("There is already dev in the task!");
        }

        taskFind.setDeveloper(devFind);
        taskFind.setIdDeveloper(devFind.getId());
        taskRepository.save(taskFind);
        log.info("Join dev task success!");

        return mapper.taskEntityToTask(taskFind);
    }


    public TaskEntity findTaskDB(UUID idTask) {
        return taskRepository.findById(idTask)
                .orElseThrow(() -> new BusinessException("Task not found!"));
    }
}
