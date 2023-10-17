package com.br.hexagonal.application.ports.in;

import com.br.hexagonal.application.domain.Task;

import java.util.UUID;

public interface GetTaskForDeveloperUserCasePort {

    Task getTaskForDeveloper(String emailDev, UUID idTask);
}
