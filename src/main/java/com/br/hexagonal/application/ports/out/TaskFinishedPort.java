package com.br.hexagonal.application.ports.out;

import com.br.hexagonal.application.domain.Task;

import java.util.UUID;

public interface TaskFinishedPort {
    Task finishedTask(UUID idTask);
}
