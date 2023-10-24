package com.br.hexagonal.application.usecases;

import com.br.hexagonal.application.domain.Task;
import com.br.hexagonal.application.ports.in.JoinDevTaskUserCasePort;
import com.br.hexagonal.application.ports.out.JoinDevTaskPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class JoinDevTaskUserCaseImpl implements JoinDevTaskUserCasePort {

    private final JoinDevTaskPort joinDevTaskPort;

    @Override
    public Task joinDevTask(UUID idDev, UUID idTask) {
        return joinDevTaskPort.joinDevTask(idDev, idTask);
    }
}
