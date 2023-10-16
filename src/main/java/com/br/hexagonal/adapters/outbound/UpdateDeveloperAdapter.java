package com.br.hexagonal.adapters.outbound;

import com.br.hexagonal.adapters.inbound.entity.DeveloperEntity;
import com.br.hexagonal.adapters.inbound.mapper.DeveloperMapper;
import com.br.hexagonal.adapters.outbound.repository.DeveloperRepository;
import com.br.hexagonal.application.domain.Developer;
import com.br.hexagonal.application.ports.out.UpdateDeveloperPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Log4j2
@Component
@RequiredArgsConstructor
public class UpdateDeveloperAdapter implements UpdateDeveloperPort {

    private final DeveloperRepository developerRepository;
    private final FindDeveloperAdapter findDeveloperAdapter;
    private final DeveloperMapper mapper;

    @Override
    public Developer updateDeveloper(UUID id, Developer developer) {
        DeveloperEntity developerFindForUpdate = findDeveloperAdapter.findDeveloperDB(id);
        DeveloperEntity developerEntity = mapper.developerToDeveloperEntity(developer);

        developerFindForUpdate.setNameDeveloper(developerEntity.getNameDeveloper());
        developerFindForUpdate.setEmail(developerEntity.getEmail());
        developerFindForUpdate.setPositionLevel(developerEntity.getPositionLevel());

        developerRepository.save(developerFindForUpdate);
        log.info("Developer update success!");

        return mapper.developerEntityToDeveloper(developerFindForUpdate);
    }
}
