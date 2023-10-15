package com.br.hexagonal.application.ports.out;

import com.br.hexagonal.application.domain.Developer;

public interface DeveloperRepositoryPort {

    Developer save(Developer developer);
}
