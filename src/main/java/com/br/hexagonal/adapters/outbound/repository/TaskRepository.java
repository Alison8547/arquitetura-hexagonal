package com.br.hexagonal.adapters.outbound.repository;

import com.br.hexagonal.adapters.inbound.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {

    List<TaskEntity> findAllByStatus(Boolean status);
}
