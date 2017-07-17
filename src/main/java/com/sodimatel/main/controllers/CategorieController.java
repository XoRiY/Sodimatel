package com.sodimatel.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sodimatel.main.domain.Categorie;
import com.sodimatel.main.services.ServiceImpl;

@RestController
public class CategorieController {

	@Autowired
	private ServiceImpl serviceImp;
	
	@RequestMapping("/categories")
	public List<Categorie> getAllCategorie(){
		return serviceImp.getAllCategorie();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/categories")
	public void ajouterCategorie(@RequestBody Categorie categorie){
		serviceImp.insertCategorie(categorie);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value="/categories/{idCategorie}")
	public void updateCategorie(@RequestBody Categorie categorie, @PathVariable Long idCategorie){
		categorie.setIdCategorie(idCategorie);
		serviceImp.updateCategorie(categorie);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/categories/{idCategorie}")
	public void deleteOneCategorie(@PathVariable Long idCategorie){
		Categorie categorie = new Categorie();
		categorie.setIdCategorie(idCategorie);
		serviceImp.deleteCategorie(categorie);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/categories/name/{categorie}")
	public Categorie getOneCategorie(@PathVariable (name="categorie")String categorie){
		return serviceImp.getCategorieBy(categorie);
	}
	@RequestMapping("/categories/id/{idCategorie}")
	public Categorie getOneCategorie(@PathVariable(name="idCategorie") Long idCategorie){
		return serviceImp.getCategorieBy(idCategorie);
	}
	
}
