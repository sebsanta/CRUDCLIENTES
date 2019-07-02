package com.duoc.restspringjpa;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.duoc.restspringjpa.modelo.Cliente;
import com.duoc.restspringjpa.modelo.repository.ClienteDAO;




@RunWith(SpringRunner.class)
@DataJpaTest

public class ClienteTests {
	
	@Autowired
	TestEntityManager manager;
	
	@Autowired
	ClienteDAO dao;

	@Before
	public void setUp() throws Exception {
		
		Cliente cliente = new Cliente("16553589-8","sebastian","santander","ssantandersnw@gmail.com","+56952433370");
		this.manager.persist(cliente);
		cliente = new Cliente("7983141-7","hugo","ignacio","ssantandersnw@gmail.com","+5693241244");
		this.manager.persist(cliente);
	}

	@Test
	public void buscarUnUsuarioMedianteSuIdResultTrue() {
	System.out.println(this.dao.findById("16553589-8").get());
	assertTrue(true);
	}
	
	@Test
	public void buscarTodosLosUsuarios2InsertadosVerdadero() {
		int cuantos = this.dao.findAll().size();
		assertTrue("son " + cuantos + " pero deberia ser 2", cuantos == 2 );
	}
	
	
	@Test
	public void eliminar1UsuarioResultTrue() {
		this.dao.deleteById("16553589-8");
		int cuantos = this.dao.findAll().size();
		assertTrue("Son " + cuantos + "usuarios y deberian ser 1", cuantos == 1 );
	}
	
	
	@Test
	public void cuandoModificamosNombredtEntoncesSeObtieneModificado() {
		this.dao.save(new Cliente("99999-9","pedro","piedra","ssantandersnw@gmail.com","+5693241244"));
		Cliente pedro = this.dao.findById("99999-9").get();
		assertNotNull(pedro);
		assertTrue("Es " + pedro.getNombres() + " pero deberia ser pedro ", pedro.getNombres().equals("pedro"));
	}
	

}
