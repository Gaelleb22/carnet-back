package dev.carnet.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.carnet.entity.Citation;
import dev.carnet.entity.User;

@Repository
public interface CitationRepository extends JpaRepository<Citation, UUID> {

}
