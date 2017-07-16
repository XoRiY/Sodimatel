package com.sodimatel.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sodimatel.main.domain.Marque;
import com.sodimatel.main.services.ServiceImpl;

@RestController
public class MarqueController {

	@Autowired
	private ServiceImpl serviceImp;
	
	@RequestMapping(method = RequestMethod.GET,value="/marques")
	public List<Marque> getAllMarques() {
		return serviceImp.getAllMarques();
	}
	

	
	@RequestMapping(method = RequestMethod.POST, value="/marques")
	public void ajouterMarque(@RequestBody Marque marque){
		serviceImp.insertMarque(marque);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value="/marques/{idMarque}")
	public void updateType(@RequestBody Marque marque, @PathVariable Long idMarque){
		marque.setIdMarque(idMarque);
		serviceImp.updateMarque(marque);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/marques/{idMarque}")
	public void deleteOneMarque(@PathVariable Long idMarque){
		serviceImp.deleteMarque(idMarque);
	}
	
	@RequestMapping("/marques/name/{marque}")
	public Marque getOneType(@PathVariable String marque){
		return serviceImp.getMarqueBy(marque);
	}
	@RequestMapping("/marques/id/{idMarque}")
	public Marque getOneMarque(@PathVariable(name="idMarque") Long idMarque){
		return serviceImp.getMarqueBy(idMarque);
	}
	
}
