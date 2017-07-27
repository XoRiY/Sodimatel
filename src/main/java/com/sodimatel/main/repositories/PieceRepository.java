package com.sodimatel.main.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sodimatel.main.domain.Appareil;
import com.sodimatel.main.domain.Categorie;
import com.sodimatel.main.domain.Piece;

public interface PieceRepository extends JpaRepository<Piece, Long>{


	
	List<Piece> findPieceEquivlenteBy(Appareil appareil, Categorie categorie);
	List<Piece> findPiecesByAppareilsAndCategorie(Set<Appareil> appareils, Categorie categorie);
	
	public abstract List<Piece> getPiecesOriginesBy(Categorie categorie);

	public abstract List<Piece> getPiecesOriginesBy(Appareil appareil);

	List<Piece> findByAppareils(Set<Appareil> appareils);
	
	List<Piece> findByCategorie(Categorie categorie);
	
	List<Piece> findByPieceOrigine(Piece pieceOrigine);

	//public abstract Piece findByReferencePiece(String referencePiece);




	
}
