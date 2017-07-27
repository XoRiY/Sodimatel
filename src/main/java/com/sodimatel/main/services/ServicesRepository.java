package com.sodimatel.main.services;

import java.util.List;
import java.util.Set;

import com.sodimatel.main.domain.*;

public interface ServicesRepository {

//
//	public abstract List<Adresse> getAdresseByClient(Client client);
//
//	public abstract List<Adresse> getAdresseByCommande(Commande commande);
//
//	public abstract List<Adresse> getAllAdresse();
//
//	public abstract Adresse insertAdresse(Adresse adresse);
//
//	public abstract Adresse updateAdresse(Adresse newAdresse);
//
//	public abstract int deleteAdresse(Adresse adresse);
//	
//	public abstract Adresse getAdresseID(Long idADresse);
//
//
//	/************ Appareil **************/
//
	public abstract Appareil insertAppareil(Appareil appareil);

	public abstract List<Appareil> getAppareilBy(Marque marque, Type type);

	public abstract void deleteAppareil(Appareil appareil);

	public abstract List<Appareil> getAllAppareils();

	public abstract Appareil getAppareilBy(Long idAppareil);

	public abstract Appareil getAppareilBy(String referenceAppareil);

	public abstract void updateAppareil(Appareil appareil);

	public abstract List<Appareil> getAppareilsByMarque(Marque marque);

	public abstract List<Appareil> getAppareilsByType(Type type);

//	public abstract List<String> searchAppareil(String reference);
//
	/************ Categorie **************/

	public abstract Categorie insertCategorie(Categorie categorie);

	public abstract List<Categorie> getAllCategorie();

	public abstract void deleteCategorie(Categorie categorie);

	public abstract Categorie getCategorieBy(String libelle);

	public abstract void updateCategorie(Categorie categorie);

	public abstract Categorie getCategorieBy(Long idCategorie);

//	/************ Client **************/
//
//	public abstract Client getClientById(Long idClient);
//
//	public abstract Client getClientByEmail(String Email);
//
//	public abstract Client getClientByTel(String Telephone);
//
//	public abstract Client getClientByCommande(Commande commande);
//
//	public abstract List<Client> getAllClients();
//
//	public abstract void updateClient(Client newClient);
//
//	public abstract Client deleteClient(Client client);
//
//	public abstract Client insertClient(Client client);
//
//	/************* Commande **************/
//
//	public abstract Commande insererCommande(Commande commande);
//
//	public abstract Commande getCommandByID(Long idCommande);
//
//	public abstract List<Commande> getCommandeByClient(Client client);
//
//	public abstract List<Commande> getAllCommande();
//
//	public abstract void update(Commande commande);
//
//	public abstract void annulerCommande(Commande commande);
//
//	public abstract void ValiderCommande(Commande commande, Client client);
//	
//	public abstract void deleteCommande(Commande commande);
//
//	
//	/************* LigneDeCommande **************/
//
//		
//	public abstract LigneDeCommande insererLigneDeCommande(LigneDeCommande ligneDeCommande);
//
//	public abstract LigneDeCommande getLigneDeCommandeByID(Long idLigneDeCommande);
//
//	public abstract List<LigneDeCommande> getLigneDeCommandeByCommande(Commande commande);
//
//	public abstract List<LigneDeCommande> getAllLigneDeCommande();
//	
//	public abstract void update(LigneDeCommande ligneDeCommande);
//
//	public abstract void deleteLigneDeCommande(LigneDeCommande ligneDeCommande);
//	
//	
	/************ Marque **************/

	public abstract Marque insertMarque(Marque marque);

	public abstract List<Marque> getAllMarques();

	public abstract int desableMarque(Marque marque);

	public abstract Marque getMarqueBy(String libelle);

	public abstract Marque getMarqueBy(Long idMarque);

	public abstract int enableMarque(Marque marque);

	public abstract void updateMarque(Marque marque);

	public abstract void deleteMarque(Marque marque);

	public abstract List<String> searchMarque(String name);

	//public abstract Set<Marque> getMarquesByType(Type type);
//
	/************ Piece **************/

	public abstract Piece insertPiece(Piece piece);

	public abstract Set<Piece> getAllPiecesBy(Appareil appareil, Categorie categorie);

	public abstract List<Piece> getPiecesOriginesBy(Appareil appareil, Categorie categorie);

	public abstract List<Piece> getPiecesEquivalentesBy(Appareil appareil, Categorie categorie);

	public abstract List<Piece> getPiecesOriginesBy(Categorie categorie);

	public abstract List<Piece> getPiecesOriginesBy(Appareil appareil);

	public abstract List<Piece> getPiecesEquivalentesBy(Categorie categorie);

	public abstract List<Piece> getPiecesEquivalentesBy(Appareil appareil);

	public abstract List<Piece> getAllPiecesBy(Appareil appareil);

	public abstract List<Piece> getAllPiecesBy(Categorie categorie);

	public abstract List<Piece> getAllPieces();

	public abstract List<Piece> getPiecesEquivalentesBy(Piece pieceOrigine);

	public abstract void associePieceAppareil(Piece piOrigine, Appareil appareil);

	public abstract Piece getPieceById(Long idPiece);

	public abstract Piece getPieceBy(String referencePiece);

	public abstract void deletePiece(Piece pi);

	public abstract void updatePiece(Piece newPiece);

	/************ Type **************/

	public abstract Type insertType(Type type);

	public abstract List<Type> getAllTypes();

	public abstract Type getTypeBy(String libelle);

	public abstract Type getTypeBy(Long idType);

	public abstract Type updateType(Type type);

	public abstract void deleteType(Long type);
	
	public abstract void deleteMarque(Long idMarque);

//	public abstract List<String> searchType(String name);
//
//	public abstract Set<Type> getTypesByMarque(Marque marque);
//
//	/************ Document **************/
//
//	public abstract List<Document> getDocumentBy(Piece piece);
//
//	public abstract Document insertDocument(Document document, Piece pieceOrigine);
//
//	public abstract int deleteDocument(Document document);
//
//	public abstract List<Document> getDocumentBy( String referencePiece);
//
//	public Document getDocumentById(Long idDoc);
//
//	/************ Image **************/
//
//	public abstract List<Image> getImageBy(Piece piece);
//
//	public abstract List<Image> getImageBy(String referencePiece);
//
//	public abstract Image insertImage(Image image);
//
//	public abstract int deleteImage(Image image);
//
//	public Image getImageById(Long idImage);

}
