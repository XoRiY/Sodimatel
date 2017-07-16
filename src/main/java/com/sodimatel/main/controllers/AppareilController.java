package com.sodimatel.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sodimatel.main.domain.Appareil;
import com.sodimatel.main.services.ServiceImpl;

@RestController
public class AppareilController {

	@Autowired
	private ServiceImpl serviceImp;
	
	@RequestMapping("/appareils")
	public List<Appareil> getAllAppareils() {
		return serviceImp.getAllAppareils();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/appareils/id/{idAppareil}")
	public Appareil getOneAppareil(@PathVariable Long idAppareil){
		return serviceImp.getAppareilBy(idAppareil);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/appareils")
	public void ajouterAppareil(@RequestBody Appareil Appareil){
		serviceImp.insertAppareil(Appareil);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value="/appareils/{idAppareil}")
	public void updateAppareil(@RequestBody Appareil appareil, @PathVariable Long idAppareil){
		appareil.setIdAppareil(idAppareil);
		serviceImp.updateAppareil(appareil);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/appareils/{idAppareil}")
	public void deleteOneAppareil(@PathVariable Long idAppareil){
		Appareil app = new Appareil();
		app.setIdAppareil(idAppareil);
		serviceImp.deleteAppareil(app);
	}
	
	@RequestMapping("/appareils/reference/{reference}")
	public Appareil getOneAppareil(@PathVariable String reference){
		return serviceImp.getAppareilBy(reference);
	}
	
}
