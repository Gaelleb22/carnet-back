package dev.carnet.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.carnet.entity.AppliUser;

@Repository
public interface AppliUserRepository extends JpaRepository<AppliUser, UUID> {
	
	Optional<AppliUser> findByPseudo(String pseudo);
	
	Optional<AppliUser> findByEmail(String email);

}
