package com.sodimatel.main.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sodimatel.main.domain.Type;

@Service
public class TypeRepositoryImpl {

	@Autowired
	private TypeRepository typeRepository;
	
	@PersistenceContext
	private EntityManager em;

	public TypeRepository getTypeRepository() {
		return typeRepository;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setTypeRepository(TypeRepository typeRepository) {
		this.typeRepository = typeRepository;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Type> getAllTypes() {
		List<Type> types = new ArrayList<>();
		typeRepository.findAll().forEach(types::add);
		return types;
	}

	public Type getTypeById(Long idType) {
		return typeRepository.findOne(idType);

	}

	public void ajouterType(Type type) {
		typeRepository.save(type);

	}

	public Type updateType(Long idType, Type type) {
		type.setIdType(idType);
		typeRepository.save(type);
		return type;
	}

	public void deleteType(Long idType) {
		typeRepository.delete(idType);
	}

	public Type getBy(String libelle) {
		return em.createNamedQuery("Type.getByType", Type.class).setParameter("type", libelle).getSingleResult();
	}

}
