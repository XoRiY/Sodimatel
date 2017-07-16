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
@Table(name = "TYPES_APPAREILS")
@NamedQueries(value = { @NamedQuery(name = "Type.getAll", query = "select t from Type t"),
		@NamedQuery(name = "Type.getByID", query = "select t from Type t where t.idType =:id"),
		@NamedQuery(name = "Type.getByType", query = "select t from Type t where t.type =:type"),
		// @NamedQuery(
		// name="Type.update", query="UPDATE Type t SET t.type=:newType where
		// t.type=:oldType"),
		@NamedQuery(name = "Type.delete", query = "delete from Type t where t.type =:type")

})

public class Type implements Serializable {

	private static final long serialVersionUID = 2874186151522842632L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TYPE_APPAREIL")
	private Long idType;

	@Column(name = "LIBELLE", unique = true, nullable = false, length = 50)
	@NotNull
	@Size(min = 3, max = 50, message = "la taille doit �tre comprise entre {min} et  {max}")
	private String type;

	// @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, orphanRemoval =
	// true, cascade = { CascadeType.PERSIST,
	// CascadeType.MERGE, CascadeType.REMOVE })
	// private Set<Appareil> appareils = new HashSet<>();

	/*************************************************/

	public Type() {
	}

	public Type(Long idType, String libelle) {
		this.idType = idType;
		this.type = libelle;
	}

	public Type(String libelle) {
		this.type = libelle;
	}

	@Override
	public String toString() {
		return "Type [idType=" + idType + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Type other = (Type) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdType() {
		return idType;
	}

	public String getType() {
		return type;
	}

	public void setIdType(Long idType) {
		this.idType = idType;
	}

	public void setType(String type) {
		this.type = type;
	}

	/*************************************************/
	//
	// public void addAppareil(Appareil appareil) {
	// appareils.add(appareil);
	// appareil.setType(this);
	// }
	//
	// public void removeAppareil(Appareil appareil) {
	// appareils.add(appareil);
	// appareil.setType(this);
	// }
	
	
	
	
}
