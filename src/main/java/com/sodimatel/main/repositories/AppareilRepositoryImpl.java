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

	@PersistenceContext
	EntityManager em;

	public Appareil insertAppareil(Appareil appareil) {
		appareilRepo.save(appareil);
		return appareil;
	}

	public List<Appareil> getAppareilBy(Marque marque, Type type) {
		return appareilRepo.findAll();
	}

	// @Interceptors(ValidationInsertInterceptor.class)
	public List<Appareil> getBy(Marque marque, Type type) {

		List<Appareil> appareils;
		appareils = em.createNamedQuery("Appareil.getBy_Marque_Type", Appareil.class).setParameter("marque", marque)
				.setParameter("type", type).getResultList();

		return appareils;
	}

	public void delete(Appareil appareil) {
		appareilRepo.delete(appareil);
	}

	public List<Appareil> getAll() {

		List<Appareil> appareils;

		appareils = appareilRepo.findAll();
		// appareils =
		// sessionFactory.getCurrentSession().createNamedQuery("Appareil.getAll",
		// Appareil.class).getResultList();

		return appareils;

	}

	public Appareil getAppareilBy(Long idAppareil) {

		Appareil appareil;

		appareil = appareilRepo.findOne(idAppareil);

		return appareil;

	}

	public Appareil getAppareilBy(String ref_Model) {

		Appareil appareil;

		appareil = em.createNamedQuery("Appareil.getByRef", Appareil.class).setParameter("referenceAppareil", ref_Model)
				.getSingleResult();

		return appareil;

	}


	public List<Appareil> getAppareilBy(Marque marque) {
		List<Appareil> appareils;
		appareils = em.createQuery("select app from Appareil as app where app.marque =:marque", Appareil.class)
				.setParameter("marque", marque).getResultList();
		return appareils;
	}

	public List<Appareil> getAppareilBy(Type type) {
		List<Appareil> appareils;
		appareils = em.createQuery("select app from Appareil as app where app.type =:type", Appareil.class)
				.setParameter("type", type).getResultList();
		return appareils;
	}

//	@Override
//	public List<String> searchAppareil(String reference) {
//
//		String query = "select app.referenceAppareil from Appareil as app where app.referenceAppareil like :ref";
//		List<String> referencesStrings;
//		referencesStrings = sessionFactory.getCurrentSession().createQuery(query, String.class)
//				.setParameter("ref", reference + "%").getResultList();
//		return referencesStrings;
//
//	}

	
	public void updateAppareil(Appareil appareil) {
		appareilRepo.save(appareil);
	}

}
