package com.sodimatel.main.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.sodimatel.main.domain.Categorie;

public class CategorieRepositoryImpl  {
	
	@Autowired
	CategorieRepository  categorieRepo;
	
	@PersistenceContext
	EntityManager em;
	
	public void update(Categorie categorie) {
		categorieRepo.save(categorie);
	}

	public Categorie getBy(String libelle) {
		return em.createNamedQuery("Categorie.getByLibelle", Categorie.class)
				.setParameter("libelle", libelle).getSingleResult();
	}

	public void delete(Categorie categorie) {
		categorieRepo.delete(categorie);
	}

	public List<Categorie> getAllCategorie() {
		return categorieRepo.findAll();
	}

	public Categorie insert(Categorie categorie) {
		return categorieRepo.save(categorie);
	}

	public Categorie getBy(Long idCategorie) {
		return categorieRepo.findOne(idCategorie);
	}

	
}
