package com.br.hexagonal.application.ports.out;

import com.br.hexagonal.application.domain.Developer;

import java.util.UUID;

public interface UpdateDeveloperPort {

    Developer updateDeveloper(UUID id, Developer developer);
}
