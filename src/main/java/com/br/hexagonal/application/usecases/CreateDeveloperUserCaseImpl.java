package com.br.hexagonal.application.usecases;

import com.br.hexagonal.application.domain.Developer;
import com.br.hexagonal.application.ports.in.CreateDeveloperUserCasePort;
import com.br.hexagonal.application.ports.out.CreateDeveloperPort;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CreateDeveloperUserCaseImpl implements CreateDeveloperUserCasePort {

    private final CreateDeveloperPort createDeveloperPort;

    @Override
    public Developer createDeveloper(Developer developer) {
        return createDeveloperPort.save(developer);
    }
}
