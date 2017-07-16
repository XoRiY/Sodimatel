package com.sodimatel.main.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Panier implements Serializable {

	private static final long serialVersionUID = -2541928572784589939L;



	private List<LigneDePanier> ligneDePaniers = new ArrayList<>();


	private Double totalPanier = 0.0;



	private Adresse adresseLivraison = new Adresse();
	
	


	private Adresse adresseFacturation = new Adresse();




	private Integer nombreDeLigne = 0;

	public Panier() {

	}

	public void ajouterLigneDePanier(LigneDePanier ligneDePanier) {

		ajouterLigneDePanier(ligneDePanier, true);
	}

	void ajouterLigneDePanier(LigneDePanier ligneDePanier, boolean set) {

		if (ligneDePanier != null) {
			if (ligneDePaniers.contains(ligneDePanier)) {
				System.out.println("et des fois, quand c'est equals, bah il passe plutot par la");
				(ligneDePaniers.get(ligneDePaniers.indexOf(ligneDePanier))).plusN(ligneDePanier.getQuantite());
			} else {
				System.out.println("d'habitude Y passe par la");
				ligneDePanier.setNumeroLigne(++nombreDeLigne);
				ligneDePaniers.add(ligneDePanier);
			}
			if (set) {
				ligneDePanier.setPanier(this, false);
			}
		}
		ligneDePanier.setTotalLigneCommande();
		this.totalPanier = totalPanier + ligneDePanier.getTotalLignePanier();
	}

	public void setTotalCommande(Double totalPanier) {
		this.totalPanier = totalPanier;
	}

	public void supprimerLigneDeCommande(LigneDePanier ligneDePanier) {
		ligneDePaniers.remove(ligneDePanier);
		ligneDePanier.setPanier(null);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<LigneDePanier> getLigneDePaniers() {
		return ligneDePaniers;
	}

	public Double getTotalPanier() {
		return totalPanier;
	}

	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}

	public Integer getNombreDeLigne() {
		return nombreDeLigne;
	}

	public void setLigneDePaniers(List<LigneDePanier> ligneDePaniers) {
		this.ligneDePaniers = ligneDePaniers;
	}

	public void setTotalPanier(Double totalPanier) {
		this.totalPanier = totalPanier;
	}

	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public void setNombreDeLigne(Integer nombreDeLigne) {
		this.nombreDeLigne = nombreDeLigne;
	}

	@Override
	public String toString() {
		return "Panier [totalPanier=" + totalPanier + ", nombreDeLigne=" + nombreDeLigne + "]";
	}

	
	
	
	
}
