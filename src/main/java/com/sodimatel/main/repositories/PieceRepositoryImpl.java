package com.sodimatel.main.repositories;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.sodimatel.main.domain.Appareil;
import com.sodimatel.main.domain.Categorie;
import com.sodimatel.main.domain.Piece;

public class PieceRepositoryImpl {

	@PersistenceContext
	EntityManager em;

	@Autowired
	PieceRepository pieceRepo;

	public Piece insert(Piece piece) {
		return pieceRepo.save(piece);
	}

	public Set<Piece> getAllBy(Appareil appareil, Categorie categorie) {

		

		List<Piece> piecesOrigines = getOriginesBy(appareil, categorie);

		List<Piece> piecesEquivalentes = getEquivalentesBy(appareil, categorie);

		Set<Piece> pieces = new HashSet<>();
		piecesOrigines.forEach(pieces::add);
		piecesEquivalentes.forEach(pieces::add);


		return pieces;
	}

	public List<Piece> getOriginesBy(Appareil appareil, Categorie categorie) {
		Set<Appareil> appareils = new HashSet<>();
		appareils.add(appareil);
		List<Piece> pieces = pieceRepo.findPiecesByAppareilsAndCategorie(appareils,categorie)
				.stream().filter(piece -> piece.getPieceOrigine()==null).collect(Collectors.toList());
		
		return pieces;
	}

	public List<Piece> getEquivalentesBy(Appareil appareil, Categorie categorie) {
		Set<Appareil> appareils = new HashSet<>();
		appareils.add(appareil);
		List<Piece> piecesOrigine = pieceRepo.findPiecesByAppareilsAndCategorie(appareils, categorie).
				stream().collect(Collectors.toList());
		List<Piece> pieceEquiv = new ArrayList<>();
		for (Piece piece : piecesOrigine) {
			piece.getPieceEquivalentes().forEach(pieceEquiv::add);
		}
		return pieceEquiv;
	}

	public List<Piece> getOriginesBy(Categorie categorie) {
		return pieceRepo.findByCategorie(categorie);
	}

	public List<Piece> getOriginesBy(Appareil appareil) {
		return null;
	}

	public List<Piece> getEquivalentesBy(Categorie categorie) {

		return null;
	}

	public List<Piece> getEquivalentesBy(Appareil appareil) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Piece> getAllBy(Appareil appareil) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Piece> getAllBy(Categorie categorie) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Piece> getAll() {
		return pieceRepo.findAll();
	}

	public List<Piece> getEquivalentesBy(Piece pieceOrigine) {
		// TODO Auto-generated method stub
		return null;
	}

	public Piece getPieceById(Long idPiece) {
		return pieceRepo.findOne(idPiece);
	}

	public void associe(Piece piOrigine, Appareil appareil) {

	}

	public Piece getPieceBy(String ref_piece) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Piece pi) {
		// TODO Auto-generated method stub

	}

	public void update(Piece newPiece) {
		// TODO Auto-generated method stub

	}

}
