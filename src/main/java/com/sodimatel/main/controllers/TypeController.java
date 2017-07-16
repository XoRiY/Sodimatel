package com.sodimatel.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sodimatel.main.domain.Type;
import com.sodimatel.main.services.ServiceImpl;

@RestController
public class TypeController {

	@Autowired
	private ServiceImpl serviceImp;
	
	@RequestMapping("/types")
	public List<Type> getAllTypes() {
		return serviceImp.getAllTypes();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/types/id/{idType}")
	public Type getOneType(@PathVariable Long idType){
		return serviceImp.getTypeBy(idType);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/types")
	public void ajouterType(@RequestBody Type type){
		serviceImp.insertType(type);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value="/types/{idType}")
	public void updateType(@RequestBody Type type, @PathVariable Long idType){
		type.setIdType(idType);
		serviceImp.updateType(type);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/types/{idType}")
	public void deleteOneType(@PathVariable Long idType){
		serviceImp.deleteType(idType);
	}
	
	@RequestMapping("/types/name/{libelle}")
	public Type getOneType(@PathVariable String libelle){
		return serviceImp.getTypeBy(libelle);
	}
	
}
