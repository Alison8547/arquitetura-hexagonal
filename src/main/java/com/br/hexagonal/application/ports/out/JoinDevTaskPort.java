package com.br.hexagonal.application.ports.out;

import com.br.hexagonal.application.domain.Task;

import java.util.UUID;

public interface JoinDevTaskPort {

    Task joinDevTask(UUID idDev, UUID idTask);
}
