package com.br.hexagonal.application.usecases;

import com.br.hexagonal.application.domain.Task;
import com.br.hexagonal.application.ports.in.GetTaskForDeveloperUserCasePort;
import com.br.hexagonal.application.ports.out.GetTaskForDeveloperPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class GetTaskForDeveloperUserCaseImpl implements GetTaskForDeveloperUserCasePort {

    private final GetTaskForDeveloperPort getTaskForDeveloperPort;

    @Override
    public Task getTaskForDeveloper(String emailDev, UUID idTask) {
        return getTaskForDeveloperPort.getTaskForDeveloper(emailDev, idTask);
    }
}
