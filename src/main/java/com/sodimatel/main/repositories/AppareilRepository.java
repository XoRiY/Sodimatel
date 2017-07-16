package com.sodimatel.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sodimatel.main.domain.Appareil;
import java.lang.String;
import java.util.List;

public interface AppareilRepository extends JpaRepository<Appareil, Long>{

	List<Appareil> findByReferenceAppareil(String referenceappareil);
}
