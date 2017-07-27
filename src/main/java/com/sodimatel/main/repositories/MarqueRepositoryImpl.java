package com.sodimatel.main.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sodimatel.main.domain.Marque;


@Service
public class MarqueRepositoryImpl {

	@Autowired
	private MarqueRepository marqueRepository;

	@PersistenceContext
	private EntityManager em;

	// @Interceptors({ MarqueInterceptor.class })
	public Marque insert(Marque marque) {
		marqueRepository.save(marque);
		return marque;
	}

	public List<Marque> findAll() {
		return marqueRepository.findAll();
	}

	public int desable(Marque r) {
		int i = em.createNamedQuery("Marque.desable").setParameter("marque", r.getMarque()).executeUpdate();
		return i;
	}

	public int enable(Marque r) {

		int i = em.createNamedQuery("Marque.enable").setParameter("marque", r.getMarque()).executeUpdate();

		return i;
	}

	public Marque getBy(String libelle) {

		return marqueRepository.findByMarque(libelle);

	}

	public Marque update(Marque marque) {
		return marqueRepository.save(marque);

	}

	public Marque getMarqueById(Long idMarque) {
		return marqueRepository.findOne(idMarque);
	}

	public void delete(Marque marque) {
		marqueRepository.delete(marque);
	}

	public List<String> searchMarque(String marque) {
		String query = "select m.marque from Marque m where m.marque like :marque";
		return em.createQuery(query, String.class).setParameter("marque", marque + "%").getResultList();
	}

	public void delete(Long idMarque) {
		marqueRepository.delete(idMarque);
	}

	
}
