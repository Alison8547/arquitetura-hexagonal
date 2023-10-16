package com.br.hexagonal.application.ports.out;

import com.br.hexagonal.application.domain.Task;

public interface CreateTaskPort {

    Task createTask(Task task);
}
