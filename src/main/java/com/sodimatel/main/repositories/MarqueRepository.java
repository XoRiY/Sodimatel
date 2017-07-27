package com.sodimatel.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sodimatel.main.domain.Marque;

public interface MarqueRepository extends JpaRepository<Marque, Long>{

	Marque findByMarque(String marque);
	
}
