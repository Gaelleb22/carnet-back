package dev.carnet.entity;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**Super Classe de User et Recette
 * @author gaell
 *
 */
@MappedSuperclass
public class EntiteBase {
	
	@Id
	private UUID uuid;
	private LocalDate dateCreation;
	
	
	/**Constructor
	 * @param uuid
	 * @param dateCreation
	 */
	public EntiteBase() {
		this.uuid = UUID.randomUUID();
		this.dateCreation = LocalDate.now();
	}

	public UUID getUuid() {
		return uuid;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

}
