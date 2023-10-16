package com.br.hexagonal.application.usecases;

import com.br.hexagonal.application.domain.Developer;
import com.br.hexagonal.application.ports.in.FindDeveloperUserCasePort;
import com.br.hexagonal.application.ports.out.FindDeveloperPort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class FindDeveloperUserCaseImpl implements FindDeveloperUserCasePort {

    private final FindDeveloperPort findDeveloperPort;

    @Override
    public Optional<Developer> findDeveloper(UUID id) {
        return findDeveloperPort.findDeveloper(id);
    }
}
