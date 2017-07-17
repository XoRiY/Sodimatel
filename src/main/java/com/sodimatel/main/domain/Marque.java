package com.sodimatel.main.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sodimatel.main.domain.enumerated.EtatMarque;

@Entity
@Table(name = "MARQUES_APPAREILS")
@NamedQueries(value = { @NamedQuery(name = "Marque.getAll", query = "select m from Marque m"),
		@NamedQuery(name = "Marque.getByID", query = "select m from Marque m where m.idMarque =:id"),
		@NamedQuery(name = "Marque.getByMarque", query = "select m from Marque m where m.marque =:libelle"),
		@NamedQuery(name = "Marque.update", query = "update Marque m set m.marque=:newMarque where m.marque=:oldMarque"),
		@NamedQuery(name = "Marque.desable", query = "update Marque m set m.etatMarque = 'INACTIVE' where m =:marque"),
		@NamedQuery(name = "Marque.enable", query = "update Marque m set m.etatMarque =  'ACTIVE' where m =:marque"),
		@NamedQuery(name = "Marque.delete", query = "delete from Marque m where m.marque =:marque") })
public class Marque implements Serializable {


	private static final long serialVersionUID = 69974464551573784L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MARQUE")
	private Long idMarque;

	@Column(name = "LIBELLE", unique = true, nullable = false, length = 50)
	@Size(min = 2, max = 50, message = "la taille doit être comprise entre {min} et  {max}")
	@NotNull
	private String marque;

	@Column(name = "ETAT", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private EtatMarque etatMarque;

	public Marque() {
	}

	public Marque(Long idMarque, String marque, EtatMarque etatMarque) {
		super();
		this.idMarque = idMarque;
		this.marque = marque;
		this.etatMarque = etatMarque;
	}

	public Marque(String marque, EtatMarque etatMarque) {
		super();
		this.marque = marque;
		this.etatMarque = etatMarque;
	}

	@Deprecated
	public Marque(String marque) {
		this.marque = marque;
		this.etatMarque = EtatMarque.ACTIVE;
	}

	public Long getIdMarque() {
		return idMarque;
	}

	public String getMarque() {
		return marque;
	}

	public EtatMarque getEtatMarque() {
		return etatMarque;
	}

	public void setIdMarque(Long idMarque) {
		this.idMarque = idMarque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public void setEtatMarque(EtatMarque etatMarque) {
		this.etatMarque = etatMarque;
	}

	@Override
	public String toString() {
		return "Marque [idMarque=" + idMarque + ", marque=" + marque + ", etatMarque=" + etatMarque + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marque == null) ? 0 : marque.hashCode());
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
		Marque other = (Marque) obj;
		if (marque == null) {
			if (other.marque != null)
				return false;
		} else if (!marque.equals(other.marque))
			return false;
		return true;
	}
	
	
	

}
