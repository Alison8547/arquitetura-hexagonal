package com.br.hexagonal.adapters.outbound;

import com.br.hexagonal.adapters.inbound.mapper.TaskMapper;
import com.br.hexagonal.adapters.outbound.repository.TaskRepository;
import com.br.hexagonal.application.domain.Task;
import com.br.hexagonal.application.ports.out.ListFinishTasksPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListFinishTasksAdapter implements ListFinishTasksPort {

    private final TaskRepository taskRepository;
    private final TaskMapper mapper;
    private static final boolean FINISHED = false;

    @Override
    public List<Task> listFinishTasks() {
        return taskRepository.findAllByStatus(FINISHED).stream()
                .map(mapper::taskEntityToTask)
                .toList();
    }
}
