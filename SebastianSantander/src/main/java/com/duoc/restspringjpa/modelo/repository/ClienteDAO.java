package com.duoc.restspringjpa.modelo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.restspringjpa.modelo.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, String>{

	Optional<Cliente> findByNombres(String nombre);

}
