package com.sodimatel.main.domain;
/* */
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "APPAREILS")
@NamedQueries(value = { 
		@NamedQuery(
				name = "Appareil.getAll", 
				query = "select app From Appareil as app"),
		@NamedQuery(
				name = "Appareil.getBy_Marque_Type", 
				query = "select app from Appareil as app where app.marque=:marque and app.type=:type"),
		@NamedQuery(
				name = "Appareil.getByRef", 
				query = "select app from Appareil as app where app.referenceAppareil=:referenceAppareil"),
		@NamedQuery(
				name = "Appareil.getByIdAppareil", 
				query = "select app from Appareil as app where app.idAppareil=:idAppareil"),
		@NamedQuery(
				name = "Appareil.deleteByRef", 
				query = "delete from Appareil as app where app.referenceAppareil=:referenceAppareil")  })
@Getter
@Setter
public class Appareil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8404292144807257847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_APPAREIL")
	private Long idAppareil;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_TYPE_APPAREIL", nullable = false)
	@NotNull
	private Type type;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_MARQUE", nullable = false)
	@NotNull
	private Marque marque;
	
	@Column(name = "REFERENCE_APPAREIL", nullable = false, length = 20, unique = true)
	@NotNull
	@Size(min=10, max =20, message = "la taille doit �tre comprise entre {min} et  {max}")
	private String referenceAppareil;
	
	@Column(name = "DESCRIPTION", nullable= false,length = 250)
	@Size(min=10, max =250, message = "la taille doit �tre comprise entre {min} et  {max}")
	@NotNull
	private String description;
	
	@ManyToMany(mappedBy = "appareils")
	@JsonIgnore
	private Set<Piece> pieces = new HashSet<>();

	
	public Appareil() {

	}

	public Appareil(Long id_Appareil, Type type_Appareil, Marque marque, String ref_Appareil, String description) {
		this.idAppareil = id_Appareil;
		this.type = type_Appareil;
		this.marque = marque;
		this.referenceAppareil = ref_Appareil;
		this.description = description;
	}
	@Deprecated
	public Appareil(Type type_Appareil, Marque marque, String ref_Appareil, String description) {
		this.type = type_Appareil;
		this.marque = marque;
		this.referenceAppareil = ref_Appareil;
		this.description = description;
	}


	public void addPiece(Piece piece) {
		pieces.add(piece);
	}

	public void removePiece(Piece piece) {
		pieces.remove(piece);		
	}


	@Override
	public String toString() {
		return "Appareil [idAppareil=" + idAppareil + ", type=" + type + ", marque=" + marque + ", referenceAppareil="
				+ referenceAppareil + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((referenceAppareil == null) ? 0 : referenceAppareil.hashCode());
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
		Appareil other = (Appareil) obj;
		if (referenceAppareil == null) {
			if (other.referenceAppareil != null)
				return false;
		} else if (!referenceAppareil.equals(other.referenceAppareil))
			return false;
		return true;
	}
	
	
	
	
	
}