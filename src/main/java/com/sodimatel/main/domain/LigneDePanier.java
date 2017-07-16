package com.sodimatel.main.domain;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class LigneDePanier implements Serializable {

	private static final long serialVersionUID = 6758167292163425760L;

	
	@Min(0)
	private Integer numeroLigne = 0;

	
	
	@Min(0)
	private Short quantite = 0;

	@NotNull()
	private Piece piece;

	private Double totalLignePanier = 0.0;


	@NotNull
	private Panier panier;

	public LigneDePanier() {

	}

	public LigneDePanier(Piece piece, Short quantite) {
		this.piece = piece;
		this.quantite = quantite;
	}

	public void setTotalLigneCommande() {
		this.totalLignePanier =
				piece.getPrix()
				* quantite;
	}

	public void plusUn() {
		++quantite;
	}

	public void moinsUn() {
		--quantite;
	}

	public void plusN(Short n) {
		this.quantite = (short) (quantite + n);
	}

	public void setNumeroLigne(Integer numeroLigne) {
		this.numeroLigne = numeroLigne;
	}

	public void setPanier(Panier panier) {
		setPanier(panier, true);
	}

	void setPanier(Panier panier, boolean add) {
		this.panier = panier;
		if (panier != null && add) {
			panier.ajouterLigneDePanier(this, false);
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getNumeroLigne() {
		return numeroLigne;
	}

	public Short getQuantite() {
		return quantite;
	}

	public Piece getPiece() {
		return piece;
	}

	public Double getTotalLignePanier() {
		return totalLignePanier;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setQuantite(Short quantite) {
		this.quantite = quantite;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public void setTotalLignePanier(Double totalLignePanier) {
		this.totalLignePanier = totalLignePanier;
	}

}
