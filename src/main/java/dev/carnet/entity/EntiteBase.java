package dev.carnet.entity;

import java.time.LocalDate;
import java.util.UUID;

/**Super Classe de User et Recette
 * @author gaell
 *
 */
public class EntiteBase {
	
	private UUID uuid;
	private LocalDate dateCreation;
	
	
	/**Constructor
	 * @param uuid
	 * @param dateCreation
	 */
	public EntiteBase() {
		super();
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
