package com.br.hexagonal.application.usecases;

import com.br.hexagonal.application.domain.Developer;
import com.br.hexagonal.application.ports.in.UpdateDeveloperUserCasePort;
import com.br.hexagonal.application.ports.out.UpdateDeveloperPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdateDeveloperUserCaseImpl implements UpdateDeveloperUserCasePort {

    private final UpdateDeveloperPort updateDeveloperPort;

    @Override
    public Developer updateDeveloper(UUID id, Developer developer) {
        return updateDeveloperPort.updateDeveloper(id, developer);
    }
}
