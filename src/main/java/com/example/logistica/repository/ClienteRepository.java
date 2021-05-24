package com.example.logistica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.logistica.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	List<Cliente> findAll();
}
