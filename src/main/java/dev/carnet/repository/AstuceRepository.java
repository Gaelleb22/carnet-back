package dev.carnet.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.carnet.entity.Astuce;

@Repository
public interface AstuceRepository extends JpaRepository<Astuce, UUID> {

}
