package com.app.parcelmachineservice.infrastructure.output.persistence.repository;

import com.app.parcelmachineservice.infrastructure.output.persistence.entity.ParcelMachineEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface ParcelMachineRepository extends ListCrudRepository<ParcelMachineEntity, UUID> {
}
