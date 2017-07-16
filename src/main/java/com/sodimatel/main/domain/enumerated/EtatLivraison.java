package com.sodimatel.main.domain.enumerated;

public enum EtatLivraison {

	CHEZ_LE_TRANSPORTEUR("Commande chez le transporteur");

	private String valeur ;
	EtatLivraison(String etat){
		valeur = etat;
	}

	@Override
	public String toString() {
	return valeur;
	}
	
	
	
	

}
