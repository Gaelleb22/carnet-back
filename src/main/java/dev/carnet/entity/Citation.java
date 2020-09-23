package dev.carnet.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

/**Citation
 * @author gaell
 *
 */
@Entity
public class Citation extends EntiteBase {
	
	private String auteur;
	private LocalDate date;
	private String citation;
	
	
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getCitation() {
		return citation;
	}
	public void setCitation(String citation) {
		this.citation = citation;
	}
	

}
