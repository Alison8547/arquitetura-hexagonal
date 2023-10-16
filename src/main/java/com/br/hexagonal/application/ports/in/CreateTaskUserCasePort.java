package com.br.hexagonal.application.ports.in;

import com.br.hexagonal.application.domain.Task;

public interface CreateTaskUserCasePort {

    Task createTask(Task task);
}
