package com.sodimatel.main.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sodimatel.main.domain.enumerated.Pays;
import com.sodimatel.main.domain.enumerated.TypeAdresse;
import com.sodimatel.main.domain.enumerated.TypeVoie;


@Entity
@Table(name = "ADRESSES")
@NamedQueries(value = { @NamedQuery(name = "Adresse.getAll", query = "select a from Adresse a"),
		@NamedQuery(name = "Adresse.findByClient", query = "select a from Adresse a where a.client =:client"),
		@NamedQuery(name = "Adresse.findByCommande", query = "select a from Adresse a where a.commande =:commande") })
public class Adresse implements Serializable {

	
	public Long getIdAdresse() {
		return idAdresse;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9078013865582458915L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ADRESSE", nullable = false, unique = true)
	private Long idAdresse;

	@Column(name = "NUMERO_VOIE", nullable = false)
	@Min(1)
	@NotNull
	private Integer numeroVoie;

	@Column(name = "TYPE_DE_LA_VOIE", nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull
	private TypeVoie typeVoie;

	@Column(name = "NOM_VOIE", nullable = false, length = 120)
	@Size(min = 2, max = 120, message = "la taille doit �tre comprise entre {min} et  {max}")
	@NotNull
	private String nomVoie;

	@Column(name = "COMPLEMENT_ADRESSE")
	private String complementAdresse;

	@Column(name = "COMPLEMENT_ADRESSE2")
	private String complementAdresse2;

	@Column(name = "COMPLEMENT_ADRESSE3")
	private String complementAdresse3;

	@Column(name = "CODE_POSTAL", nullable = false)
	@NotNull
	private Integer codePostal;

	@Column(name = "VILLE", nullable = false, length = 45)
	@Size(min = 2, max = 30, message = "la taille doit �tre comprise entre {min} et  {max}")
	@NotNull
	private String ville;

	@Column(name = "PAYS", nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Pays pays;

	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "ID_COMMANDE")
	private Commande commande;

	@Column(name = "TYPE_ADRESSE", nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull
	private TypeAdresse typeAdresse;

	public Adresse() {
	}

	public Adresse(Integer numeroVoie, TypeVoie typeVoie, String nomVoie, Integer codePostal, String ville, Pays pays,
			TypeAdresse typeAdresse) {
		super();
		this.numeroVoie = numeroVoie;
		this.typeVoie = typeVoie;
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.typeAdresse = typeAdresse;
	}

	

	public Integer getNumeroVoie() {
		return numeroVoie;
	}

	public TypeVoie getTypeVoie() {
		return typeVoie;
	}

	public String getNomVoie() {
		return nomVoie;
	}

	public String getComplementAdresse() {
		return complementAdresse;
	}

	public String getComplementAdresse2() {
		return complementAdresse2;
	}

	public String getComplementAdresse3() {
		return complementAdresse3;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public Pays getPays() {
		return pays;
	}

	public Client getClient() {
		return client;
	}

	public Commande getCommande() {
		return commande;
	}

	public TypeAdresse getTypeAdresse() {
		return typeAdresse;
	}

	public void setIdAdresse(Long idAdresse) {
		this.idAdresse = idAdresse;
	}

	public void setNumeroVoie(Integer numeroVoie) {
		this.numeroVoie = numeroVoie;
	}

	public void setTypeVoie(TypeVoie typeVoie) {
		this.typeVoie = typeVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

	public void setComplementAdresse2(String complementAdresse2) {
		this.complementAdresse2 = complementAdresse2;
	}

	public void setComplementAdresse3(String complementAdresse3) {
		this.complementAdresse3 = complementAdresse3;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public void setTypeAdresse(TypeAdresse typeAdresse) {
		this.typeAdresse = typeAdresse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
		result = prime * result + ((nomVoie == null) ? 0 : nomVoie.hashCode());
		result = prime * result + ((numeroVoie == null) ? 0 : numeroVoie.hashCode());
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
		result = prime * result + ((typeAdresse == null) ? 0 : typeAdresse.hashCode());
		result = prime * result + ((typeVoie == null) ? 0 : typeVoie.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		Adresse other = (Adresse) obj;
		if (codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!codePostal.equals(other.codePostal))
			return false;
		if (nomVoie == null) {
			if (other.nomVoie != null)
				return false;
		} else if (!nomVoie.equals(other.nomVoie))
			return false;
		if (numeroVoie == null) {
			if (other.numeroVoie != null)
				return false;
		} else if (!numeroVoie.equals(other.numeroVoie))
			return false;
		if (pays != other.pays)
			return false;
		if (typeAdresse != other.typeAdresse)
			return false;
		if (typeVoie != other.typeVoie)
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		
		
		return "Adresse [idAdresse=" + idAdresse + ", numeroVoie=" + numeroVoie + ", typeVoie=" + typeVoie
				+ ", nomVoie=" + nomVoie + ", complementAdresse=" + complementAdresse + ", complementAdresse2="
				+ complementAdresse2 + ", complementAdresse3=" + complementAdresse3 + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", pays=" + pays + ", typeAdresse=" + typeAdresse + "]";
	}



}
