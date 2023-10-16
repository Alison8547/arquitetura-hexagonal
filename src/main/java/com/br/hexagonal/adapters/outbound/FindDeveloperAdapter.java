package com.br.hexagonal.adapters.outbound;

import com.br.hexagonal.adapters.inbound.entity.DeveloperEntity;
import com.br.hexagonal.adapters.inbound.mapper.DeveloperMapper;
import com.br.hexagonal.adapters.outbound.repository.DeveloperRepository;
import com.br.hexagonal.application.domain.Developer;
import com.br.hexagonal.application.ports.out.FindDeveloperPort;
import com.br.hexagonal.config.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FindDeveloperAdapter implements FindDeveloperPort {

    private final DeveloperRepository developerRepository;
    private final DeveloperMapper mapper;

    @Override
    public Optional<Developer> findDeveloper(UUID id) {
        DeveloperEntity developerEntity = findDeveloperDB(id);

        return Optional.ofNullable(mapper.developerEntityToDeveloper(developerEntity));
    }

    public DeveloperEntity findDeveloperDB(UUID id) {
        return developerRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Developer not found!"));
    }
}
