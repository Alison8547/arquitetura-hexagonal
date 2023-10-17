package com.br.hexagonal.adapters.outbound.repository;

import com.br.hexagonal.adapters.inbound.entity.DeveloperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeveloperRepository extends JpaRepository<DeveloperEntity, UUID> {

    Optional<DeveloperEntity> findByEmail(String email);
}
