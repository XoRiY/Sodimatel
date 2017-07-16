package com.sodimatel.main.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "IMAGES", uniqueConstraints = @UniqueConstraint(columnNames = { "NOM_IMAGE", "EXTENSION_IMAGE",
		"URL_IMAGE" }, name = "UNQ_NOM_IMAGE_EXTENSION_URL_ID_PIECE"))
@NamedQueries(value = { @NamedQuery(name = "Images.getALl", query = "select i from Image i"),
		@NamedQuery(name = "Image.getByIdImage", query = "select i from Image i where i.idImage=:IdIimage"),
		@NamedQuery(name = "Image.delete", query = "delete from Image i where i.idImage=:idImage") })

public class Image implements Serializable {

	private static final long serialVersionUID = 6815334468779686900L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_IMAGE")
	private Long idImage;

	@Column(name = "NOM_IMAGE", length = 40, nullable = false)
	private String nomImage;

	@Column(name = "EXTENSION_IMAGE", nullable = false, length = 12)
	private String extensionImage;

	@Column(name = "URL_IMAGE", nullable = false, length = 60)
	private String urlImage;

	@ManyToOne
	@JoinColumn(name = "ID_PIECE")
	private Piece piece;

	public Image() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extensionImage == null) ? 0 : extensionImage.hashCode());
		result = prime * result + ((nomImage == null) ? 0 : nomImage.hashCode());
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
		Image other = (Image) obj;
		if (extensionImage == null) {
			if (other.extensionImage != null)
				return false;
		} else if (!extensionImage.equals(other.extensionImage))
			return false;
		if (nomImage == null) {
			if (other.nomImage != null)
				return false;
		} else if (!nomImage.equals(other.nomImage))
			return false;
		return true;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdImage() {
		return idImage;
	}

	public String getNomImage() {
		return nomImage;
	}

	public String getExtensionImage() {
		return extensionImage;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setIdImage(Long idImage) {
		this.idImage = idImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	public void setExtensionImage(String extensionImage) {
		this.extensionImage = extensionImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	
	

}
