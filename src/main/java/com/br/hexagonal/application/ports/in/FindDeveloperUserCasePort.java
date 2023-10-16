package com.br.hexagonal.application.ports.in;

import com.br.hexagonal.application.domain.Developer;

import java.util.Optional;
import java.util.UUID;

public interface FindDeveloperUserCasePort {

    Optional<Developer> findDeveloper(UUID id);
}
