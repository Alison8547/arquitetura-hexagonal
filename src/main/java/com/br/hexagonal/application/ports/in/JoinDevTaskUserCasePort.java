package com.br.hexagonal.application.ports.in;

import com.br.hexagonal.application.domain.Task;

import java.util.UUID;

public interface JoinDevTaskUserCasePort {

    Task joinDevTask(UUID idDev, UUID idTask);
}
