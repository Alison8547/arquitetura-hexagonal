package com.br.hexagonal.adapters.outbound;

import com.br.hexagonal.adapters.inbound.mapper.TaskMapper;
import com.br.hexagonal.adapters.outbound.repository.TaskRepository;
import com.br.hexagonal.application.domain.Task;
import com.br.hexagonal.application.ports.out.GetTaskForDeveloperPort;
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


    // TODO

    @Override
    public Task getTaskForDeveloper(String emailDev, UUID idTask) {
        return null;
    }
}
