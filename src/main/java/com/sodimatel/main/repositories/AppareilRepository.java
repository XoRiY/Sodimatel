package com.sodimatel.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sodimatel.main.domain.Appareil;
import java.lang.String;
import java.util.List;
import com.sodimatel.main.domain.Marque;
import com.sodimatel.main.domain.Type;

public interface AppareilRepository extends JpaRepository<Appareil, Long>{


	Appareil findByReferenceAppareil(String referenceAppareil);
	List<Appareil> findByMarque(Marque marque);
	List<Appareil> findByType(Type type);
	List<Appareil> findByTypeAndMarque(Type type, Marque marque);

}
