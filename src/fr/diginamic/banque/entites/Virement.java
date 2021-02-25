/**
 * 
 */
package fr.diginamic.banque.entites;

import javax.persistence.Column;
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
	private Client client;

	public Virement() {
		
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
