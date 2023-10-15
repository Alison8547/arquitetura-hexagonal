package com.br.hexagonal.application.ports.in;

import com.br.hexagonal.application.domain.Developer;

public interface CreateDeveloperUserCasePort {

    Developer createDeveloper(Developer developer);
}
