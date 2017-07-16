package com.sodimatel.main.domain.enumerated;

public enum TypeAdresse {
		FACTURATION("Adresse de Facturation"), LIVRAISON("Adresse de Livraison");
		
		private String valeur ;
		
		TypeAdresse(String etat){
			valeur = etat;
		}

		@Override
		public String toString() {
		return valeur;
		}
}
