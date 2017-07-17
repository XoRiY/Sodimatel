package com.sodimatel.main.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "CATEGORIES_PIECES")
@NamedQueries(value = { @NamedQuery(name = "Categorie.getAll", query = "select c from Categorie c"),
		@NamedQuery(name = "Categorie.getByID", query = "select c from Categorie c where c.idCategorie =:id"),
		@NamedQuery(name = "Categorie.getByLibelle", query = "select c from Categorie c where c.libelle =:libelle"),
		@NamedQuery(name="Categorie.update", query="UPDATE Categorie c SET c.libelle=:newCategorie where c.libelle=:oldCategorie"),
		@NamedQuery(name = "Categorie.delete", query = "delete from Categorie c where c.libelle =:libelle") })
public class Categorie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4632236586401357299L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CATEGORIE")
	private Long idCategorie;

	@Column(name = "LIBELLE", nullable = false, unique = true, length = 50)
	@Size(min = 2, max = 50, message = "la taille doit être comprise entre {min} et  {max}")
	@NotNull
	private String libelle;

	public Categorie() {
	}

	public Categorie(String libelle) {
		this.libelle = libelle;
	}

	public Categorie(Long idCategorie, String libelle) {
		this.idCategorie = idCategorie;
		this.libelle = libelle;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
		Categorie other = (Categorie) obj;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", libelle=" + libelle + "]";
	}
			

}
