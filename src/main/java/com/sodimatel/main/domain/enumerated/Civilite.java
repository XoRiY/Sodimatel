package com.sodimatel.main.domain.enumerated;

public enum Civilite {
	M("Monsieur"), Mme("Madame"), Mlle("Mademoiselle");
	
	private String valeur ;
	Civilite(String etat){
		valeur = etat;
	}

	@Override
	public String toString() {
	return valeur;
	}
}