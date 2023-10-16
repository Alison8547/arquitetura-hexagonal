package com.br.hexagonal.application.usecases;

import com.br.hexagonal.application.domain.Task;
import com.br.hexagonal.application.ports.in.CreateTaskUserCasePort;
import com.br.hexagonal.application.ports.out.CreateTaskPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateTaskUserCasImpl implements CreateTaskUserCasePort {

    private final CreateTaskPort createTaskPort;

    @Override
    public Task createTask(Task task) {
        return createTaskPort.createTask(task);
    }
}
