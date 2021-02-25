/**
 * 
 */
package fr.diginamic.banque;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.banque.entites.Adresse;
import fr.diginamic.banque.entites.AssuranceVie;
import fr.diginamic.banque.entites.Banque;
import fr.diginamic.banque.entites.Client;
import fr.diginamic.banque.entites.Compte;
import fr.diginamic.banque.entites.LivretA;
import fr.diginamic.banque.entites.Operation;
import fr.diginamic.banque.entites.Virement;

/**
 * @author EtienneUrbano
 *
 */
public class TestJpaBanque {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Creation de l'entity Manager à partir du peristence unit "pu_banque" de mon
		// fichier persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_banque");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Adresse adresse1 = new Adresse();
		adresse1.setCodePostal(84200);
		adresse1.setVille("Carpentras");
		adresse1.setNumero(44);
		adresse1.setRue("Impasse Gatelier");
		
		Adresse adresse2 = new Adresse();
		adresse2.setCodePostal(69007);
		adresse2.setVille("Lyon");
		adresse2.setNumero(345);
		adresse2.setRue("Rue Vauban");
		
		Banque banque1 = new Banque();
		banque1.setNom("CreditAgricole");
		em.persist(banque1);
		
		Banque banque2 = new Banque();
		banque2.setNom("SocieteGenerale");
		em.persist(banque2);
		
		Banque banque3 = new Banque();
		banque3.setNom("BanquePopulaire");
		em.persist(banque3);
		
		Banque banque4 = new Banque();
		banque4.setNom("BanquePostale");
		em.persist(banque4);
		
		Client client1 = new Client();
		client1.setAdresse(adresse1);
		client1.setBanque(banque1);
		client1.setDateNaissance(new Date(92, 4, 19));
		client1.setNom("Ribière");
		client1.setPrenom("Andrea");
		em.persist(client1);
		
		Client client2 = new Client();
		client2.setAdresse(adresse2);
		client2.setBanque(banque2);
		client2.setDateNaissance(new Date(65, 5, 6));
		client2.setNom("Grebon");
		client2.setPrenom("Sophie");
		em.persist(client2);
		
		Client client3 = new Client();
		client3.setAdresse(adresse2);
		client3.setBanque(banque4);
		client3.setDateNaissance(new Date(75, 11, 24));
		client3.setNom("Safran");
		client3.setPrenom("Gregoire");
		em.persist(client3);
		
		Operation ope1 = new Operation();
		ope1.setDate(new Date(121, 4, 6));
		ope1.setMontant(545d);
		ope1.setMotif("Loyer mars");
		em.persist(ope1);
		
		Operation ope2 = new Operation();
		ope2.setDate(new Date(121, 3, 26));
		ope2.setMontant(3209d);
		ope2.setMotif("Facture artisan plâtrier");
		em.persist(ope2);
		
		Operation ope3 = new Operation();
		ope3.setDate(new Date(121, 3, 12));
		ope3.setMontant(32d);
		ope3.setMotif("Gain jeu à gratter");
		em.persist(ope3);
		
		Compte compte1 = new Compte();
		compte1.setNumero("45F543F54387787");
		compte1.setSolde(700d);
		em.persist(compte1);
		
		Compte compte2 = new Compte();
		compte2.setNumero("758834888R73D34");
		compte2.setSolde(1800d);
		em.persist(compte2);
		
		Compte compte3 = new Compte();
		compte3.setNumero("5883778929374");
		compte3.setSolde(1200d);
		em.persist(compte3);
		
		// Implémentation de la table CLIENTS_COMPTES
		compte1.getClients().add(client1);
		compte1.getClients().add(client2);
		client1.getComptes().add(compte3);
		
		Virement virement1 = new Virement();
		virement1.setClient(client2);
		virement1.setDate(new Date(121, 3, 22));
		virement1.setMontant(321d);
		virement1.setMotif("Cadeau d'anniversaire");
		em.persist(virement1);
		
		Virement virement2 = new Virement();
		virement2.setClient(client1);
		virement2.setDate(new Date(121, 2, 2));
		virement2.setMontant(45d);
		virement2.setMotif("Avance sur les courses");
		em.persist(virement2);
		
		AssuranceVie assurVie1 = new AssuranceVie();
		assurVie1.setDateFin(new Date(145, 9, 14));
		assurVie1.setTaux(2.75d);
		assurVie1.setClients(Arrays.asList(client1, client2));
		assurVie1.setNumero("FR58827377583839");
		assurVie1.setSolde(6700d);
		em.persist(assurVie1);
		
		LivretA livretA1 = new LivretA();
		livretA1.setClients(Arrays.asList(client3));
		livretA1.setNumero("FR6993872H37462");
		livretA1.setSolde(2346d);
		livretA1.setTaux(0.75d);
		livretA1.getOperations().add(virement1);
		livretA1.getOperations().add(ope2);		
		em.persist(livretA1);
				
		et.commit();
		
	}

}
