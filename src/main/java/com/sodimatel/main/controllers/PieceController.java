package com.sodimatel.main.controllers;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RestController;

import com.sodimatel.main.domain.Appareil;
import com.sodimatel.main.domain.Categorie;
import com.sodimatel.main.domain.Piece;
import com.sodimatel.main.services.ServiceImpl;

@RestController
public class PieceController {

	private static Logger logger = Logger.getLogger(Class.class);

	@Autowired
	private ServiceImpl serviceImp;

	@RequestMapping("/pieces")
	public List<Piece> getAllAppareils() {
		return serviceImp.getAllPieces();
	}

	@RequestMapping(method = GET, value = "/pieces/id/{idPiece}")
	public Piece getOnePiece(@PathVariable Long idPiece) {
		return serviceImp.getPieceById(idPiece);
	}

	@RequestMapping(method = POST, value = "/pieces")
	public String insertPiece(@RequestBody Piece piece) {
		String result = "échec";
		try {
			serviceImp.insertPiece(piece);
			result = "reussi";
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	// query parameter 
	@RequestMapping(value = "/piecesEquivalentes", method = GET)
	public Set<Piece> getPieceByAppareilAndCategorie(@RequestParam(value="appareil", required = true) Appareil appareil,
			@RequestParam(value="categorie", required = true) Categorie categorie) {
		Set<Piece> pieces = serviceImp.getAllPiecesBy(appareil, categorie);
		logger.info(pieces.size());
		return pieces;
	}

	public List<Piece> getPiecesOriginesBy(Appareil Appareil, Categorie categorie) {
		return null;

	}

	@RequestMapping(value = "/piecesEquivalentes/appareils/{idAppareil}/categories/{idCategorie}", method = GET)
	public List<Piece> getPiecesEquivalentesBy(@PathVariable(name="idAppareil") Appareil appareil, @PathVariable(name="idCategorie") Categorie categorie) {
		List<Piece> pieces = serviceImp.getPiecesEquivalentesBy(appareil, categorie);
		return pieces;
	}

	@RequestMapping(value = "/piecesOrigines/categorie/{idcategorie}", method = GET)
	public List<Piece> getPiecesOriginesBy(@PathVariable(name="idcategorie") Categorie categorie) {		
		return serviceImp.getPiecesOriginesBy(categorie);
	}

	public List<Piece> getPiecesOriginesBy(Appareil appareil) {
		return null;
	}

	public List<Piece> getPiecesEquivalentesBy(Categorie categorie) {
		return null;
	}

	public List<Piece> getPiecesEquivalentesBy(Appareil appareil) {
		return null;
	}

	public List<Piece> getAllPiecesBy(Appareil appareil) {
		return null;
	}

	public List<Piece> getAllPiecesBy(Categorie categorie) {
		return null;
	}

	public List<Piece> getAllPieces() {
		return null;
	}

	public List<Piece> getPiecesEquivalentesBy(Piece pieceOrigine) {
		return null;
	}

	public void associePieceAppareil(Piece piOrigine, Appareil appareil) {

	}

	public Piece getPieceBy(String referencePiece) {
		return null;
	}

	public void deletePiece(Piece pi) {

	}

	public void updatePiece(Piece newPiece) {

	}

}
