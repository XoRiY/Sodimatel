package com.sodimatel.main.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.sodimatel.main.domain.enumerated.Civilite;

@Entity
@Table(name = "CLIENTS")
@NamedQueries(value = { @NamedQuery(name = "Client.getAll", query = "select c from Client c"),
		@NamedQuery(name = "Client.getClient", query = "select c from Client c where c =:client"),
		@NamedQuery(name = "Adresse.getByCommande", query = "select c from Client c join c.commandes as cmd where cmd =:commande"),
		@NamedQuery(name = "Client.getClientById", query = "select c from Client c where c.idClient=:idClient"),
		@NamedQuery(name = "Client.getClientEmail", query = "select c from Client c where c.email=:email"),
		@NamedQuery(name = "Client.getClientByTelephone", query = "select c from Client c where c.telephone=:telephone") })
public class Client implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5786839425841430962L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENT")
	private Long idClient;

	@Column(name = "EMAIL", nullable = false, unique = true)
	@Email
	@NotNull
	@Size(min = 6, max = 50, message = "la taille doit �tre comprise entre {min} et  {max}")
	private String email;

	@Column(name = "TELEPHONE", nullable = false)
	@Size(min = 9, max = 16, message = "la taille doit �tre comprise entre {min} et  {max}")
	@NotNull
	private String telephone;

	@Column(name = "NOM", nullable = false, length = 50)
	@NotNull
	@Size(min = 2, max = 50, message = "la taille doit �tre comprise entre {min} et  {max}")
	private String nom;

	@Column(name = "PRENOM", nullable = false, length = 50)
	@NotNull
	@Size(min = 2, max = 50, message = "la taille doit �tre comprise entre {min} et  {max}")
	private String prenom;

	@Column(name = "CIVILITE", nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Civilite civilite;

	@Column(name = "MOT_DE_PASSE", nullable = false)
	@NotNull
	@Size(min = 4, max = 25, message = "la taille doit �tre comprise entre {min} et  {max}")
	private String motDePasse;

	@Column(name = "DATE_INSCRIPTION")
	@Temporal(value = TemporalType.DATE)
	private Calendar DateInscriprtion = Calendar.getInstance();

	@Column(name = "DATE_NAISSANCE")
	@Temporal(value = TemporalType.DATE)
	@Past
	private Calendar DateNaissance = new GregorianCalendar();

	@OneToMany(mappedBy = "client", cascade = { CascadeType.REMOVE, CascadeType.PERSIST,
			CascadeType.MERGE }, orphanRemoval = true)
	private Set<Adresse> adresses = new HashSet<>();

	@OneToMany(mappedBy = "client", fetch= FetchType.EAGER, orphanRemoval = true)
	private List<Commande> commandes = new ArrayList<>();

	public Client() {
	}

	@Deprecated
	public Client(Long id, String nom, String prenom, String email, String telephone, Civilite civilite, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.civilite = civilite;
		this.motDePasse = motDePasse;
	}

	public void ajouterAdresse(Adresse adresse) {
		adresses.add(adresse);
		adresse.setClient(this);
	}

	public void SupprimerAdresse(Adresse adresse) {
		adresses.remove(adresse);
		adresse.setClient(null);
	}

	public void ajouterCommande(Commande commande) {
		 ajouterCommande(commande, true);
	    }

	void ajouterCommande(Commande commande, boolean set) {
	        if (commande != null) {
	            if(getCommandes().contains(commande)) {
	            	getCommandes().set(getCommandes().indexOf(commande), commande);
	            }
	            else {
	            	getCommandes().add(commande);
	            }
	            if (set) {
	                commande.setClient(this, false);
	            }
	        }
	    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdClient() {
		return idClient;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public Calendar getDateInscriprtion() {
		return DateInscriprtion;
	}

	public Calendar getDateNaissance() {
		return DateNaissance;
	}

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public void setDateInscriprtion(Calendar dateInscriprtion) {
		DateInscriprtion = dateInscriprtion;
	}

	public void setDateNaissance(Calendar dateNaissance) {
		DateNaissance = dateNaissance;
	}

	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Client other = (Client) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", email=" + email + ", telephone=" + telephone + ", nom=" + nom
				+ ", prenom=" + prenom + ", civilite=" + civilite + ", motDePasse=" + motDePasse + ", DateInscriprtion="
				+ DateInscriprtion + ", DateNaissance=" + DateNaissance + "]";
	}
		
	
	
}
