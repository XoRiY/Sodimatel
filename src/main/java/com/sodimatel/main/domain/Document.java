package com.sodimatel.main.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DOCUMENTS_PIECES")
public class Document implements Serializable {

	private static final long serialVersionUID = -4870444298604950622L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DOCUMENT")
	private Long id_Documents;


	@Column(name = "NOM_DOC",  length = 40, nullable = false)
	@NotNull
	@Size(min=2, max=40, message = "la taille doit �tre comprise entre {min} et  {max}")
	private String nom_Doc;

	
	@Column(name = "EXTENSION_DOC",  nullable = false, length = 12)
	@NotNull
	@Size(min=2, max=12, message = "la taille doit �tre comprise entre {min} et  {max}")
	private String extension_Doc;
	
	
	@Column(name = "URL_DOC", nullable = false, length = 60)
	@NotNull
	@Size(min=2, max=60, message = "la taille doit �tre comprise entre {min} et  {max}")
	private String url_Doc;

	@ManyToMany(mappedBy = "documents")
	private Set<Piece> pieces = new HashSet<>();

	public Document() {
		this.nom_Doc = "nom_Doc inconnu";
		this.extension_Doc = "extension_Doc inconnu";
		this.url_Doc = "url_Doc inconnue";
	}

	public Document(Long id_document, String nom_Doc, String extension_Doc, String url_Doc) {
		this.id_Documents = id_document;
		this.nom_Doc = nom_Doc;
		this.extension_Doc = extension_Doc;
		this.url_Doc = url_Doc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId_Documents() {
		return id_Documents;
	}

	public String getNom_Doc() {
		return nom_Doc;
	}

	public String getExtension_Doc() {
		return extension_Doc;
	}

	public String getUrl_Doc() {
		return url_Doc;
	}

	public Set<Piece> getPieces() {
		return pieces;
	}

	public void setId_Documents(Long id_Documents) {
		this.id_Documents = id_Documents;
	}

	public void setNom_Doc(String nom_Doc) {
		this.nom_Doc = nom_Doc;
	}

	public void setExtension_Doc(String extension_Doc) {
		this.extension_Doc = extension_Doc;
	}

	public void setUrl_Doc(String url_Doc) {
		this.url_Doc = url_Doc;
	}

	public void setPieces(Set<Piece> pieces) {
		this.pieces = pieces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extension_Doc == null) ? 0 : extension_Doc.hashCode());
		result = prime * result + ((nom_Doc == null) ? 0 : nom_Doc.hashCode());
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
		Document other = (Document) obj;
		if (extension_Doc == null) {
			if (other.extension_Doc != null)
				return false;
		} else if (!extension_Doc.equals(other.extension_Doc))
			return false;
		if (nom_Doc == null) {
			if (other.nom_Doc != null)
				return false;
		} else if (!nom_Doc.equals(other.nom_Doc))
			return false;
		return true;
	}
		
}
