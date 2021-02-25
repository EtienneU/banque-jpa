/**
 * 
 */
package fr.diginamic.banque.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author EtienneUrbano
 *
 */
@Entity
@Table(name="ASSURANCE_VIE")
public class AssuranceVie extends Compte {
	
	@Column(name="DATE_FIN")
	private Date DateFin;
	
	@Column(name="TAUX")
	private Double taux;
	
	public AssuranceVie() {
		
	}

	public Date getDateFin() {
		return DateFin;
	}

	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

}
