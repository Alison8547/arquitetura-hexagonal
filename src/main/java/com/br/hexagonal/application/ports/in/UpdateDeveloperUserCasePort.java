package com.br.hexagonal.application.ports.in;

import com.br.hexagonal.application.domain.Developer;

import java.util.UUID;

public interface UpdateDeveloperUserCasePort {

    Developer updateDeveloper(UUID id, Developer developer);

}
