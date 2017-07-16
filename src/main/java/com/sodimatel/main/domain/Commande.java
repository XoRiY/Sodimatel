package com.sodimatel.main.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.sodimatel.main.domain.enumerated.EtatCommande;

@Entity
@Table(name = "COMMANDES")
public class Commande implements Serializable {

	private static final long serialVersionUID = -2541928572784589939L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMMANDE")
	private Long idCommande;

	@Column(name = "DATE_COMMANDE")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Calendar dateCommande = Calendar.getInstance();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "commande", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, orphanRemoval = true)

	private Set<LigneDeCommande> ligneDeCommandes = new HashSet<>();

	@Column(name = "TOTAL_COMMANDE", scale = 2)
	private Double totalCommande = 0.0;

	@Column(name = "ETAT_COMMANDE", nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull

	private EtatCommande etatCommande;

	@OneToMany(mappedBy = "commande", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, orphanRemoval = true)
	private Set<Adresse> adresses = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CLIENT", nullable = false)
	@NotNull
	private Client client;

	@Column(name = "NOMBRE_DE_LIGNE")
	private Integer nombreDeLigne = 0;

	public Commande() {

	}

	public Commande(Long idCommande, Calendar dateCommande, Set<LigneDeCommande> ligneDeCommandes,
			Double totalCommande, EtatCommande etatCommande, Set<Adresse> adresses, Client client,
			Integer nombreDeLigne) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
		this.ligneDeCommandes = ligneDeCommandes;
		this.totalCommande = totalCommande;
		this.etatCommande = etatCommande;
		this.adresses = adresses;
		this.client = client;
		this.nombreDeLigne = nombreDeLigne;
	}


	public void ajouterLigneDeCommande(LigneDeCommande ligneDeCommande) {

		ajouterLigneDeCommande(ligneDeCommande, true);
	}

	void ajouterLigneDeCommande(LigneDeCommande ligneDeCommande, boolean set) {
		if (ligneDeCommande != null) {
			if (getLigneDeCommandes().contains(ligneDeCommande)) {
				
				for (LigneDeCommande ligneDeCommande2 : getLigneDeCommandes()) {
					if (ligneDeCommande2.equals(ligneDeCommande)) {
						ligneDeCommande2.plusN(ligneDeCommande.getQuantite());
						break;
					}
				}
			} else {
				ligneDeCommande.setNumeroLigne(++nombreDeLigne);
				getLigneDeCommandes().add(ligneDeCommande);
			}
			if (set) {
				ligneDeCommande.setCommande(this, false);
			}
		}
		ligneDeCommande.setTotalLigneCommande();
		this.totalCommande = totalCommande + ligneDeCommande.getTotalLigneDeCommande();
	}

	public void setTotalCommande(Double totalCommande) {
		this.totalCommande = totalCommande;
	}

	public void supprimerLigneDeCommande(LigneDeCommande ligneDeCommande) {
		ligneDeCommandes.remove(ligneDeCommande);
		ligneDeCommande.setCommande(null);
	}

	public void setClient(Client client) {
		setClient(client, true);
	}

	void setClient(Client client, boolean add) {
		this.client = client;
		if (client != null && add) {
			client.ajouterCommande(this, false);
		}
	}

	public void addAdresse(Adresse adresse) {
		adresses.add(adresse);
		adresse.setCommande(this);
	}

	public void supprimerAdresse(Adresse adresse) {
		adresses.remove(adresse);
		adresse.setCommande(null);
	}

	public void valider() {
		this.etatCommande = EtatCommande.VALIDER;
	}

	public void confirmer() {
		this.etatCommande = EtatCommande.CONFIRMER;
	}

	public void annuler() {
		this.etatCommande = EtatCommande.ANNULER;
	}

	public void enPreparration() {
		this.etatCommande = EtatCommande.EN_PREPARATION;
	}

	public void enLivraison() {
		this.etatCommande = EtatCommande.EN_LIVRAISON;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdCommande() {
		return idCommande;
	}

	public Calendar getDateCommande() {
		return dateCommande;
	}

	public Set<LigneDeCommande> getLigneDeCommandes() {
		return ligneDeCommandes;
	}

	public Double getTotalCommande() {
		return totalCommande;
	}

	public EtatCommande getEtatCommande() {
		return etatCommande;
	}

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	public Client getClient() {
		return client;
	}

	public Integer getNombreDeLigne() {
		return nombreDeLigne;
	}

	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}

	public void setDateCommande(Calendar dateCommande) {
		this.dateCommande = dateCommande;
	}

	public void setLigneDeCommandes(Set<LigneDeCommande> ligneDeCommandes) {
		this.ligneDeCommandes = ligneDeCommandes;
	}

	public void setEtatCommande(EtatCommande etatCommande) {
		this.etatCommande = etatCommande;
	}

	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}

	public void setNombreDeLigne(Integer nombreDeLigne) {
		this.nombreDeLigne = nombreDeLigne;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresses == null) ? 0 : adresses.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((dateCommande == null) ? 0 : dateCommande.hashCode());
		result = prime * result + ((ligneDeCommandes == null) ? 0 : ligneDeCommandes.hashCode());
		result = prime * result + ((nombreDeLigne == null) ? 0 : nombreDeLigne.hashCode());
		result = prime * result + ((totalCommande == null) ? 0 : totalCommande.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		if (adresses == null) {
			if (other.adresses != null)
				return false;
		} else if (!adresses.equals(other.adresses))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (dateCommande == null) {
			if (other.dateCommande != null)
				return false;
		} else if (!dateCommande.equals(other.dateCommande))
			return false;
		if (ligneDeCommandes == null) {
			if (other.ligneDeCommandes != null)
				return false;
		} else if (!ligneDeCommandes.equals(other.ligneDeCommandes))
			return false;
		if (nombreDeLigne == null) {
			if (other.nombreDeLigne != null)
				return false;
		} else if (!nombreDeLigne.equals(other.nombreDeLigne))
			return false;
		if (totalCommande == null) {
			if (other.totalCommande != null)
				return false;
		} else if (!totalCommande.equals(other.totalCommande))
			return false;
		return true;
	}

	
}
