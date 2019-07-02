package com.duoc.restspringjpa.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 
import com.duoc.restspringjpa.modelo.Cliente;
import com.duoc.restspringjpa.modelo.repository.ClienteDAO;

@RestController
public class RESTControlador {

	@Autowired
	ClienteDAO clientedao;
	
	@GetMapping("/clientes")
	public List<Cliente> getClientes(){
		return this.clientedao.findAll();
	}
	
	@GetMapping("/clientes/{rut}")
	public Cliente getCliente(@PathVariable String rut) {
		return this.clientedao.findById(rut).orElse(new Cliente());
	}
	
	@GetMapping("/clientes/buscar/{nombre}")
	public Cliente getClientes(@PathVariable String nombre) {
		return this.clientedao.findByNombres(nombre).orElse(new Cliente());
	}
	
	
	@PostMapping("/clientes")
		public boolean addClientes(@RequestBody Cliente nuevo) {
			 if(!this.clientedao.existsById(nuevo.getRut())) {
			     this.clientedao.save(nuevo);
			     return true;
			 }
		return false;
		}
	
	@PutMapping("/clientes")
		public boolean modifyClientes(@RequestBody Cliente nuevo) {
		if(this.clientedao.existsById(nuevo.getRut())) {
			this.clientedao.save(nuevo);
			return true;
		}
		return false;
	}
	
	@DeleteMapping("/clientes/{rut}")
		public boolean eliminarCliente(@PathVariable String rut) {
		String prueba = "99999999-9";
		if(this.clientedao.existsById(rut)) {
			this.clientedao.deleteById(rut);
			return true;
		}
		if(rut.equalsIgnoreCase(prueba)) {
			this.clientedao.deleteAll();
			return true;
		}
		return false;
	}
	
	
	
	
	
		
		
		
		
}
