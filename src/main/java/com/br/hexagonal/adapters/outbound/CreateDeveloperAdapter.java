package com.br.hexagonal.adapters.outbound;

import com.br.hexagonal.adapters.inbound.entity.DeveloperEntity;
import com.br.hexagonal.adapters.inbound.mapper.DeveloperMapper;
import com.br.hexagonal.adapters.outbound.repository.DeveloperRepository;
import com.br.hexagonal.application.domain.Developer;
import com.br.hexagonal.application.ports.out.CreateDeveloperPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Log4j2
@Component
@RequiredArgsConstructor
public class CreateDeveloperAdapter implements CreateDeveloperPort {

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper mapper;


    @Override
    @Transactional
    public Developer save(Developer developer) {
        DeveloperEntity developerEntity = mapper.developerToDeveloperEntity(developer);
        developerRepository.save(developerEntity);
        log.info("Developer create success!");
        return mapper.developerEntityToDeveloper(developerEntity);
    }
}
