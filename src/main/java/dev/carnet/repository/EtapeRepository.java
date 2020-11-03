package dev.carnet.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.carnet.entity.Etape;

@Repository
public interface EtapeRepository extends JpaRepository<Etape, UUID>{

}
