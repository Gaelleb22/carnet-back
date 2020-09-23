package dev.carnet.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**Astuce pour réaliser une recette
 * @author gaell
 *
 */
@Entity
public class Astuce extends EntiteBase {
	
	private String astuce;
	
	@ManyToOne
	@JoinColumn(name = "recette_uuid")
	@JsonBackReference
	private Recette recette;

	public String getAstuce() {
		return astuce;
	}
	public void setAstuce(String astuce) {
		this.astuce = astuce;
	}

}
