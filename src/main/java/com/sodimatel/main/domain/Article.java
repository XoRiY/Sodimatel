package com.sodimatel.main.domain;

public class Article {

	private Piece piece;

	private Integer quantite;

	private Double Total;

	public Article() {
		Total = piece.getPrix() * quantite;
	}

	/**
	 * @return the article
	 */
	public Piece getArticle() {
		return piece;
	}

	/**
	 * @return the quantite
	 */
	public Integer getQuantite() {
		return quantite;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return Total;
	}

	/**
	 * @param article
	 *            the article to set
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	/**
	 * @param quantite
	 *            the quantite to set
	 */
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Double total) {
		Total = total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Total == null) ? 0 : Total.hashCode());
		result = prime * result + ((piece == null) ? 0 : piece.hashCode());
		result = prime * result + ((quantite == null) ? 0 : quantite.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (Total == null) {
			if (other.Total != null)
				return false;
		} else if (!Total.equals(other.Total))
			return false;
		if (piece == null) {
			if (other.piece!= null)
				return false;
		} else if (!piece.equals(other.piece))
			return false;
		if (quantite == null) {
			if (other.quantite != null)
				return false;
		} else if (!quantite.equals(other.quantite))
			return false;
		return true;
	}

}
