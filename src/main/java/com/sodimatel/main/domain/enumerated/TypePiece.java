package com.sodimatel.main.domain.enumerated;

public enum TypePiece {
	ORIGINE("Piece Originale"), EQUIVALENTE("Piece Equivalente");
	private String valeur;

	TypePiece(String etat) {
		valeur = etat;
	}

	@Override
	public String toString() {

		return valeur;
	}

}


