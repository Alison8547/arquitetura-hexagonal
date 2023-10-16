package com.br.hexagonal.application.ports.out;

import com.br.hexagonal.application.domain.Developer;

import java.util.Optional;
import java.util.UUID;

public interface FindDeveloperPort {

    Optional<Developer> findDeveloper(UUID id);
}
