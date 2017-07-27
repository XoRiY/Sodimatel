package com.sodimatel.main.services;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sodimatel.main.domain.*;
import com.sodimatel.main.repositories.*;



@Service
public class ServiceImpl implements ServicesRepository, Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = -8778427171907119573L;

	@Autowired
	private MarqueRepositoryImpl marqueRepositoryImpl;
//
//	@Autowired
//	private AdresseRepositoryImpl adresseRepository;
//
	@Autowired
	private AppareilRepositoryImpl appareilRepositoryImpl;

	@Autowired
	private CategorieRepositoryImpl categorieRepository;

//	@Autowired
//	private ClientRepositoryImpl clientRepository;
//
//	@Autowired
//	private CommandeRepositoryImpl commandeRepository;
//
//	@Autowired
//	private DocumentRepositoryImpl documentRepository;
//
	@Autowired
	private PieceRepositoryImpl pieceRepository;

	@Autowired
	private TypeRepositoryImpl typeRepositoryImpl;

//	@Autowired
//	private LigneDeCommandesRepository ligneDeCommandesRepository;
//	
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	public MarqueRepository getMarqueRepository() {
//		return marqueRepository;
//	}
//
//	public AdresseRepositoryImpl getAdresseRepository() {
//		return adresseRepository;
//	}
//
//	public AppareilRepositoryImp getAppareilRepository() {
//		return appareilRepository;
//	}
//
//	public CategorieRepositoryImpl getCategorieRepository() {
//		return categorieRepository;
//	}
//
//	public ClientRepositoryImpl getClientRepository() {
//		return clientRepository;
//	}
//
//	public CommandeRepositoryImpl getCommandeRepository() {
//		return commandeRepository;
//	}
//
//	public DocumentRepositoryImpl getDocumentRepository() {
//		return documentRepository;
//	}
//
//	public PieceRepositoryImpl getPieceRepository() {
//		return pieceRepository;
//	}
//
//	public TypeRepositoryImpl gettypeRepositoryImpl() {
//		return typeRepositoryImpl;
//	}
//
//	public LigneDeCommandesRepository getLigneDeCommandesRepository() {
//		return ligneDeCommandesRepository;
//	}
//
//	public void setMarqueRepository(MarqueRepository marqueRepository) {
//		this.marqueRepository = marqueRepository;
//	}
//
//	public void setAdresseRepository(AdresseRepositoryImpl adresseRepository) {
//		this.adresseRepository = adresseRepository;
//	}
//
//	public void setAppareilRepository(AppareilRepositoryImp appareilRepository) {
//		this.appareilRepository = appareilRepository;
//	}
//
//	public void setCategorieRepository(CategorieRepositoryImpl categorieRepository) {
//		this.categorieRepository = categorieRepository;
//	}
//
//	public void setClientRepository(ClientRepositoryImpl clientRepository) {
//		this.clientRepository = clientRepository;
//	}
//
//	public void setCommandeRepository(CommandeRepositoryImpl commandeRepository) {
//		this.commandeRepository = commandeRepository;
//	}
//
//	public void setDocumentRepository(DocumentRepositoryImpl documentRepository) {
//		this.documentRepository = documentRepository;
//	}
//
//	public void setPieceRepository(PieceRepositoryImpl pieceRepository) {
//		this.pieceRepository = pieceRepository;
//	}
//
//	public void settypeRepositoryImpl(TypeRepositoryImpl typeRepositoryImpl) {
//		this.typeRepositoryImpl = typeRepositoryImpl;
//	}
//
//	public void setLigneDeCommandesRepository(LigneDeCommandesRepository ligneDeCommandesRepository) {
//		this.ligneDeCommandesRepository = ligneDeCommandesRepository;
//	}

	/****************************************************/
	/******************* Adresse ***********************/
	/****************************************************/

//	@Override
//	public List<Adresse> getAdresseByClient(Client client) {
//		List<Adresse> adresses;
//		adresses = adresseRepository.getAdresseByClient(client);
//		return adresses;
//	}
//
//	@Override
//	public List<Adresse> getAdresseByCommande(Commande commande) {
//		List<Adresse> adresses;
//		adresses = adresseRepository.getAdresseByCommande(commande);
//		return adresses;
//	}
//
//	@Override
//	public List<Adresse> getAllAdresse() {
//		List<Adresse> adresses;
//		adresses = adresseRepository.getAllAdresse();
//		return adresses;
//	}
//
//	@Override
//	// @Interceptors(ValidationInsertInterceptor.class)
//	public Adresse insertAdresse(Adresse adresse) {
//
//		return adresseRepository.insert(adresse);
//
//	}
//
//	@Override
//	public Adresse updateAdresse(Adresse newAdresse) {
//		Adresse a;
//		a = adresseRepository.updateAdresse(newAdresse);
//		return a;
//	}
//
//	@Override
//	public int deleteAdresse(Adresse adresse) {
//		adresseRepository.deleteAdresse(adresse);
//		return 0;
//
//	}
//
//	public Adresse getAdresseID(Long idADresse) {
//		Adresse adresse;
//		adresse = adresseRepository.getAdresseID(idADresse);
//		return adresse;
//	}
//
//	/****************************************************/
//	/******************* Appareil ***********************/
//	/****************************************************/
//
	@Override
	// @Interceptors(ValidationInsertInterceptor.class)
	public Appareil insertAppareil(Appareil appareil) {
		Appareil appareilPersist;
		appareilPersist = appareilRepositoryImpl.insertAppareil(appareil);
		return appareilPersist;
	}

	@Override
	public List<Appareil> getAppareilBy(Marque marque, Type type) {
		List<Appareil> appareils;
		appareils = appareilRepositoryImpl.getAppareilBy(marque, type);
		return appareils;
	}

	@Override
	public void deleteAppareil(Appareil appareil) {

		appareilRepositoryImpl.delete(appareil);

	}

	@Override
	public List<Appareil> getAllAppareils() {
		List<Appareil> appareils;
		appareils = appareilRepositoryImpl.getAll();
		return appareils;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Appareil getAppareilBy(Long idAppareil) {

		Appareil appareil;
		appareil = appareilRepositoryImpl.getAppareilBy(idAppareil);
		return appareil;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Appareil getAppareilBy(String referenceAppareil) {
		Appareil appareil;
		appareil = appareilRepositoryImpl.getAppareilBy(referenceAppareil);
		return appareil;
	}

	@Override
	public void updateAppareil(Appareil appareil) {
		appareilRepositoryImpl.updateAppareil(appareil);
	}

	@Override
	public List<Appareil> getAppareilsByMarque(Marque marque) {
		List<Appareil> appareils;
		appareils = appareilRepositoryImpl.getAppareilBy(marque);
		return appareils;

	}

	@Override
	public List<Appareil> getAppareilsByType(Type type) {
		List<Appareil> appareils;
		appareils = appareilRepositoryImpl.getAppareilBy(type);
		return appareils;
	}

//	@Override
//	// @Interceptors(ValidationParametersInterceptor.class)
//	public List<String> searchAppareil(String reference) {
//		List<String> appareils;
//		appareils = appareilRepositoryImpl.searchAppareil(reference);
//		return appareils;
//	}
//
	/****************************************************/
	/******************* Categorie **********************/
	/****************************************************/

	@Override
	// @Interceptors(ValidationInsertInterceptor.class)
	public Categorie insertCategorie(Categorie categorie) {
		return categorieRepository.insert(categorie);

	}

	@Override
	public List<Categorie> getAllCategorie() {
		List<Categorie> categories;
		categories = categorieRepository.getAllCategorie();
		return categories;
	}

	@Override
	public void deleteCategorie(Categorie categorie) {
		
		 categorieRepository.delete(categorie);
		
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Categorie getCategorieBy(String libelle) {
		Categorie categorie;
		categorie = categorieRepository.getBy(libelle);
		return categorie;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public void updateCategorie(Categorie categorie) {

		categorieRepository.update(categorie);
		
	}

	@Override
	//@Interceptors(ValidationParametersInterceptor.class)
	public Categorie getCategorieBy(Long idCategorie) {
		Categorie categorie;
		categorie = categorieRepository.getBy(idCategorie);
		return categorie;
	}

//	/****************************************************/
//	/******************* Client ***********************/
//	/****************************************************/
//
//	@Override
//	// @Interceptors(ValidationParametersInterceptor.class)
//	public Client getClientById(Long idClient) {
//		Client client;
//		client = clientRepository.getClientById(idClient);
//		return client;
//	}
//
//	@Override
//	// @Interceptors(ValidationParametersInterceptor.class)
//	public Client getClientByEmail(String Email) {
//		Client client;
//		client = clientRepository.getClientByEmail(Email);
//		return client;
//	}
//
//	@Override
//	// @Interceptors(ValidationParametersInterceptor.class)
//	public Client getClientByTel(String Telephone) {
//		Client client;
//		client = clientRepository.getClientByTel(Telephone);
//		return client;
//	}
//
//	@Override
//	public Client getClientByCommande(Commande commande) {
//		Client client;
//		client = clientRepository.getClientByCommande(commande);
//		return client;
//	}
//
//	@Override
//	public List<Client> getAllClients() {
//		List<Client> clients;
//		clients = clientRepository.getAllClients();
//		return clients;
//	}
//
//	@Override
//	public void updateClient(Client newClient) {
//
//		clientRepository.updateClient(newClient);
//
//	}
//
//	@Override
//	public Client deleteClient(Client client) {
//		Client c = clientRepository.deleteClient(client);
//		return c;
//	}
//
//	@Override
//	// @Interceptors(ValidationInsertInterceptor.class)
//	public Client insertClient(Client client) {
//		Client clientPersist;
//		clientPersist = clientRepository.inserer(client);
//		return clientPersist;
//	}
//
//	/****************************************************/
//	/******************* Commande ***********************/
//	/****************************************************/
//
//	@Override
//	// @Interceptors(ValidationInsertInterceptor.class)
//	public Commande insererCommande(Commande commande) {
//		Commande commandepersist;
//		commandepersist = commandeRepository.insererCommande(commande);
//		return commandepersist;
//	}
//
//	@Override
//	// @Interceptors(ValidationParametersInterceptor.class)
//	public Commande getCommandByID(Long idCommande) {
//		Commande commande;
//		commande = commandeRepository.getCommandByID(idCommande);
//		return commande;
//	}
//
//	@Override
//	public List<Commande> getCommandeByClient(Client client) {
//		List<Commande> commandes;
//		commandes = commandeRepository.getCommandeByClient(client);
//		return commandes;
//	}
//
//	@Override
//	public List<Commande> getAllCommande() {
//		List<Commande> commandes;
//		commandes = commandeRepository.getAllCommande();
//		return commandes;
//	}
//
//	@Override
//	public void update(Commande commande) {
//		commandeRepository.update(commande);
//	}
//
//	@Override
//	public void annulerCommande(Commande commande) {
//
//		commandeRepository.annulerCommande(commande);
//	}
//
//	@Override
//	public void ValiderCommande(Commande commande, Client client) {
//		throw new UnsupportedOperationException("not implemented yet");
//	}
//
//	@Override
//	public void deleteCommande(Commande commande) {
//
//		commandeRepository.delete(commande);
//	}
//
//	/****************************************************/
//	/******************* Marque ***********************/
//	/****************************************************/

	@Override
	// @Interceptors({ LogInterceptors.class
	// ,ValidationInsertInterceptor.class})
	public Marque insertMarque(Marque marque) {
		Marque marquePersist;
		marquePersist = marqueRepositoryImpl.insert(marque);
		return marquePersist;
	}

	@Override
	public List<Marque> getAllMarques() {
		List<Marque> marques;
		marques = marqueRepositoryImpl.findAll();
		return marques;
	}

	@Override
	public int desableMarque(Marque r) {
		int i;
		i = marqueRepositoryImpl.desable(r);
		return i;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Marque getMarqueBy(String libelle) {
		Marque marque;
		marque = marqueRepositoryImpl.getBy(libelle);
		return marque;
	}

	@Override
	// @Interceptors({ValidationParametersInterceptor.class})
	public Marque getMarqueBy(Long idMarque) {
		Marque marque;
		marque = marqueRepositoryImpl.getMarqueById(idMarque);
		return marque;
	}

	@Override
	public int enableMarque(Marque r) {
		int i;
		i = marqueRepositoryImpl.enable(r);
		return i;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public void updateMarque(Marque marque) {

		marqueRepositoryImpl.update(marque);

	}

	@Override
	public void deleteMarque(Marque r) {

		marqueRepositoryImpl.delete(r);

	}

	@Override
	public void deleteMarque(Long idMarque) {

		marqueRepositoryImpl.delete(idMarque);

	}	
	
	
	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public List<String> searchMarque(String name) {
		List<String> marquesStrings;
		marquesStrings = marqueRepositoryImpl.searchMarque(name);
		return marquesStrings;
	}

	/****************************************************/
	/******************** Piece *************************/
	/****************************************************/

	@Override
	// @Interceptors(ValidationInsertInterceptor.class)
	public Piece insertPiece(Piece piece) {
		Piece piecePersist;
		piecePersist = pieceRepository.insert(piece);
		return piecePersist;
	}

	@Override
	public Set<Piece> getAllPiecesBy(Appareil appareil, Categorie categorie) {
		
		
		return pieceRepository.getAllBy(appareil, categorie);	
	}

	@Override
	public List<Piece> getPiecesOriginesBy(Appareil appareil, Categorie categorie) {
		List<Piece> pieces;
		pieces = pieceRepository.getOriginesBy(appareil, categorie);
		return pieces;
	}

	@Override
	public List<Piece> getPiecesEquivalentesBy(Appareil appareil, Categorie categorie) {

		return pieceRepository.getEquivalentesBy(appareil, categorie);
	
	}

	@Override
	public List<Piece> getPiecesOriginesBy(Categorie categorie) {
		List<Piece> pieces;
		pieces = pieceRepository.getOriginesBy(categorie);
		return pieces;

	}

	@Override
	public List<Piece> getPiecesOriginesBy(Appareil appareil) {
		List<Piece> pieces;
		pieces = pieceRepository.getOriginesBy(appareil);
		return pieces;
	}

	@Override
	public List<Piece> getPiecesEquivalentesBy(Categorie categorie) {
		List<Piece> pieces;
		pieces = pieceRepository.getEquivalentesBy(categorie);
		return pieces;
	}

	@Override
	public List<Piece> getPiecesEquivalentesBy(Appareil appareil) {
		List<Piece> pieces;
		pieces = pieceRepository.getEquivalentesBy(appareil);
		return pieces;
	}

	@Override
	public List<Piece> getAllPiecesBy(Appareil appareil) {
		List<Piece> pieces;
		pieces = pieceRepository.getAllBy(appareil);
		return pieces;
	}

	@Override
	public List<Piece> getAllPiecesBy(Categorie categorie) {
		List<Piece> pieces;
		pieces = pieceRepository.getAllBy(categorie);
		return pieces;
	}

	@Override
	public List<Piece> getAllPieces() {
		List<Piece> pieces;
		pieces = pieceRepository.getAll();
		return pieces;
	}

	@Override
	public List<Piece> getPiecesEquivalentesBy(Piece pieceOrigine) {
		List<Piece> pieces;
		pieces = pieceRepository.getEquivalentesBy(pieceOrigine);
		return pieces;
	}

	@Override
	public void associePieceAppareil(Piece piOrigine, Appareil appareil) {
		pieceRepository.associe(piOrigine, appareil);
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Piece getPieceById(Long idPiece) {
		Piece piece;
		piece = pieceRepository.getPieceById(idPiece);
		return piece;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Piece getPieceBy(String refPiece) {
		Piece piece;
		piece = pieceRepository.getPieceBy(refPiece);
		return piece;
	}

	@Override
	public void deletePiece(Piece piece) {

		pieceRepository.delete(piece);

	}

	@Override
	public void updatePiece(Piece newPiece) {

		pieceRepository.update(newPiece);

	}

	/****************************************************/
	/********************* Type *************************/
	/****************************************************/

	@Override
	// @Interceptors(ValidationInsertInterceptor.class)
	public Type insertType(Type type) {
		 typeRepositoryImpl.ajouterType(type);
		return type;
	}

	@Override
	public List<Type> getAllTypes() {
		List<Type> types;
		types = typeRepositoryImpl.getAllTypes();
		return types;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Type getTypeBy(String libelle) {
		Type type;
		type = typeRepositoryImpl.getBy(libelle);
		return type;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Type getTypeBy(Long idType) {
		Type type;
		type = typeRepositoryImpl.getTypeById(idType);
		return type;
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public Type updateType(Type type) {
		
		return typeRepositoryImpl.updateType(null, type);
		
	}

	@Override
	// @Interceptors(ValidationParametersInterceptor.class)
	public void deleteType(Long idType) {

		typeRepositoryImpl.deleteType(idType);

	}



//	@Override
//	public List<String> searchType(String typeString) {
//
//		List<String> typesStrings;
//		typesStrings = typeRepositoryImpl.searchType(typeString);
//		return typesStrings;
//
//	}
//
//	@Override
//	// @Interceptors({ TrieTypeInterceptors.class })
//	public Set<Type> getTypesByMarque(Marque marque) {
//		Set<Type> types;
//		types = new HashSet<>();
//		types.addAll(typeRepositoryImpl.getAll());
//		return types;
//	}
//
//	/****************************************************/
//	/******************* Document ***********************/
//	/****************************************************/
//
//	@Override
//	public List<Document> getDocumentBy(Piece piece) {
//		throw new UnsupportedOperationException("not implemented yet");
//	}
//
//	@Override
//	// @Interceptors(ValidationInsertInterceptor.class)
//	public Document insertDocument(Document d, Piece piOrigine) {
//
//		return documentRepository.insert(d, piOrigine);
//	}
//
//	@Override
//	public int deleteDocument(Document document) {
//		throw new UnsupportedOperationException("not implemented yet");
//
//	}
//
//	@Override
//	// @Interceptors(ValidationParametersInterceptor.class)
//	public List<Document> getDocumentBy(String ref_piece) {
//		throw new UnsupportedOperationException("not implemented yet");
//	}
//
//	@Override
//	// @Interceptors(ValidationParametersInterceptor.class)
//	public Document getDocumentById(Long idDoc) {
//		throw new UnsupportedOperationException("not implemented yet");
//	}
//
//	/****************************************************/
//	/******************* Image ***********************/
//	/****************************************************/
//
//	@Override
//	public List<Image> getImageBy(Piece piece) {
//		throw new UnsupportedOperationException("not implemented yet");
//	}
//
//	@Override
//	// @Interceptors(ValidationParametersInterceptor.class)
//	public List<Image> getImageBy(String referencePiece) {
//		throw new UnsupportedOperationException("not implemented yet");
//	}
//
//	@Override
//	// @Interceptors(ValidationInsertInterceptor.class)
//	public Image insertImage(Image image) {
//		throw new UnsupportedOperationException("not implemented yet");
//	}
//
//	@Override
//	public int deleteImage(Image image) {
//		throw new UnsupportedOperationException("not implemented yet");
//	}
//
//	@Override
//	// @Interceptors(ValidationParametersInterceptor.class)
//	public Image getImageById(Long idImage) {
//		throw new UnsupportedOperationException("not implemented yet");
//	}
//
//	@Override
//	// @Interceptors({ TrieMarqueInterceptors.class })
//	public Set<Marque> getMarquesByType(Type type) {
//		Set<Marque> marques;
//		marques = new HashSet<>();
//		marques.addAll(marqueRepository.getAll());
//		return marques;
//	}
//
//	@Override
//	public LigneDeCommande insererLigneDeCommande(LigneDeCommande ligneDeCommande) {
//
//		LigneDeCommande ligneDeCommandesInsert;
//
//		ligneDeCommandesInsert = ligneDeCommandesRepository.insererLigneDeCommande(ligneDeCommande);
//
//		return ligneDeCommandesInsert;
//	}
//
//	@Override
//	public LigneDeCommande getLigneDeCommandeByID(Long idLigneDeCommande) {
//
//		return ligneDeCommandesRepository.getLigneDeCommandeByID(idLigneDeCommande);
//
//	}
//
//	@Override
//	public List<LigneDeCommande> getLigneDeCommandeByCommande(Commande commande) {
//		// TODO Auto-generated method stub
//		return ligneDeCommandesRepository.getLigneDeCommandeByCommande(commande);
//	}
//
//	@Override
//	public List<LigneDeCommande> getAllLigneDeCommande() {
//		// TODO Auto-generated method stub
//		return ligneDeCommandesRepository.getAllLigneDeCommande();
//	}
//
//	@Override
//	public void update(LigneDeCommande ligneDeCommande) {
//		ligneDeCommandesRepository.update(ligneDeCommande);
//	}
//
//	@Override
//	public void deleteLigneDeCommande(LigneDeCommande ligneDeCommande) {
//		ligneDeCommandesRepository.deleteLigneDeCommande(ligneDeCommande);
//
//	}
//	
}
