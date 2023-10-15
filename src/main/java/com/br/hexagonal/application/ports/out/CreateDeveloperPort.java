package com.br.hexagonal.application.ports.out;

import com.br.hexagonal.application.domain.Developer;

public interface CreateDeveloperPort {

    Developer save(Developer developer);
}
