package com.br.hexagonal.application.ports.in;

import com.br.hexagonal.application.domain.Task;

import java.util.UUID;

public interface TaskFinishedUseCasePort {
    Task finishedTask(UUID idTask);
}
