package com.example.logistica.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.logistica.model.Cliente;
import com.example.logistica.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clientes/")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repositorio;
	
	@GetMapping("/")
	public List<Cliente> listar() {
		return repositorio.findAll();
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long clienteId) {
		Optional<Cliente> cliente = repositorio.findById(clienteId);
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionarCliente(@RequestBody Cliente clienteRecebido) {
		return repositorio.save(clienteRecebido);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizarDados(@PathVariable Long clienteId ,@RequestBody Cliente cliente) {
		if(!repositorio.existsById(clienteId)){
			return ResponseEntity.notFound().build();
		}else {
			cliente.setId(clienteId);
			cliente = repositorio.save(cliente);
			return ResponseEntity.ok(cliente);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarDados(@PathVariable Long id){
		if(!repositorio.existsById(id)){
			return ResponseEntity.notFound().build();
		}else {
			repositorio.deleteById(id);
			
			return ResponseEntity.noContent().build();
		}
	}
}
