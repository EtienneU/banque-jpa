/**
 * 
 */
package fr.diginamic.banque.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author EtienneURBANO
 *
 */
@Entity
@Table(name="LIVRET_A")
public class LivretA extends Compte {
	
	@Column(name="TAUX")
	private Double taux; 
	
	public LivretA() {
		
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}
}
