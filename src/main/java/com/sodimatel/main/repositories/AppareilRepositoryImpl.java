package com.sodimatel.main.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.sodimatel.main.domain.Appareil;
import com.sodimatel.main.domain.Marque;
import com.sodimatel.main.domain.Type;

public class AppareilRepositoryImpl {

	@Autowired
	private AppareilRepository appareilRepo;

	public Appareil insertAppareil(Appareil appareil) {
		appareilRepo.save(appareil);
		return appareil;
	}

	public List<Appareil> getAppareilBy(Marque marque, Type type) {
		return appareilRepo.findByTypeAndMarque(type, marque);
	}

	public void delete(Appareil appareil) {
		appareilRepo.delete(appareil);
	}

	public List<Appareil> getAll() {

		return appareilRepo.findAll();

	}

	public Appareil getAppareilBy(Long idAppareil) {

		return appareilRepo.findOne(idAppareil);

	}

	public Appareil getAppareilBy(String referenceAppareil) {

		return appareilRepo.findByReferenceAppareil(referenceAppareil);

	}

	public List<Appareil> getAppareilBy(Marque marque) {
		return appareilRepo.findByMarque(marque);
	}

	public List<Appareil> getAppareilBy(Type type) {
		return appareilRepo.findByType(type);
	}

	// @Override
	// public List<String> searchAppareil(String reference) {
	//
	// String query = "select app.referenceAppareil from Appareil as app where
	// app.referenceAppareil like :ref";
	// List<String> referencesStrings;
	// referencesStrings = sessionFactory.getCurrentSession().createQuery(query,
	// String.class)
	// .setParameter("ref", reference + "%").getResultList();
	// return referencesStrings;
	//
	// }

	public void updateAppareil(Appareil appareil) {
		appareilRepo.save(appareil);
	}

}
