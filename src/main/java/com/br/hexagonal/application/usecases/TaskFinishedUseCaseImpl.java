package com.br.hexagonal.application.usecases;

import com.br.hexagonal.application.domain.Task;
import com.br.hexagonal.application.ports.in.TaskFinishedUseCasePort;
import com.br.hexagonal.application.ports.out.TaskFinishedPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class TaskFinishedUseCaseImpl implements TaskFinishedUseCasePort {

    private final TaskFinishedPort taskFinishedPort;

    @Override
    public Task finishedTask(UUID idTask) {
        return taskFinishedPort.finishedTask(idTask);
    }
}
