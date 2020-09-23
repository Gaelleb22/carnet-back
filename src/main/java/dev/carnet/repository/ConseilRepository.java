package dev.carnet.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.carnet.entity.Conseil;

@Repository
public interface ConseilRepository extends JpaRepository<Conseil, UUID> {

}
