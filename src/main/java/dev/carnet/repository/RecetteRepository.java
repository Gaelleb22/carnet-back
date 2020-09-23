package dev.carnet.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.carnet.entity.Recette;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, UUID> {

}
