package com.sodimatel.main.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "LIGNES_COMMANDES", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_NUM_IDCMD", columnNames = { "NUMERO_LIGNE", "ID_COMMANDE" }) })
public class LigneDeCommande implements Serializable {

	private static final long serialVersionUID = 6758167292163425760L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LIGNE_COMMANDE")
	private Integer idLigneDeCommande;

	@Column(name = "NUMERO_LIGNE", nullable = false)
	@Min(0)
	private Integer numeroLigne;

	@Column(name = "QUANTITE", nullable = false)
	@Min(0)
	private Short quantite;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PIECE", nullable = false)
	@NotNull()
	private Piece piece;

	
	@Column(name = "TOTAL_LIGNE_COMMANDE", nullable = false)
	private Double totalLigneDeCommande;

	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name = "ID_COMMANDE", nullable = false)
	@NotNull
	private Commande commande;

	public LigneDeCommande() {

	}

	public void setTotalLigneCommande() {
		this.totalLigneDeCommande = piece.getPrix() * quantite;
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

	public void setCommande(Commande commande) {
		setCommande(commande);
	}

	void setCommande(Commande commande, boolean add) {
		this.commande = commande;
		if (commande != null && add) {
			commande.ajouterLigneDeCommande(this, false);
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIdLigneDeCommande() {
		return idLigneDeCommande;
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

	public Double getTotalLigneDeCommande() {
		return totalLigneDeCommande;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setIdLigneDeCommande(Integer idLigneDeCommande) {
		this.idLigneDeCommande = idLigneDeCommande;
	}

	public void setQuantite(Short quantite) {
		this.quantite = quantite;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public void setTotalLigneDeCommande(Double totalLigneDeCommande) {
		this.totalLigneDeCommande = totalLigneDeCommande;
	}

	
	
	
}
