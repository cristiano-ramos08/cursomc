package com.cristianoramos.mc.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cristianoramos.mc.domain.Cliente;
import com.cristianoramos.mc.services.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service; //Está acessando o serviço.

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {//Esse método vai receber um ID que vai vir na URL, para isso precisa da anotação @PathVariable
		
		Cliente obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
}
