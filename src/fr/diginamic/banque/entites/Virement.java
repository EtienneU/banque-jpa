/**
 * 
 */
package fr.diginamic.banque.entites;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author urban
 *
 */
@Entity
@Table(name="VIREMENT")
public class Virement extends Operation {
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client beneficiaire;

	public Virement() {
		
	}

	public Client getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(Client client) {
		this.beneficiaire = client;
	}

}
