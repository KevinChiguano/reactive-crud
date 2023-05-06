package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.model.Persona;
import com.uce.edu.demo.repo.IPersonaRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonaService {

	@Autowired
	private IPersonaRepo personaRepo;

	public Mono<Persona> createPersona(Persona persona) {
		return personaRepo.save(persona);
	}

	public Mono<Persona> getPersonaByID(Integer id) {
		return personaRepo.findById(id);
	}

	public Flux<Persona> getAllPersonas() {
		return personaRepo.findAll();
	}

	public Mono<Void> deletePersonaById(Integer id) {
		return personaRepo.deleteById(id);
	}

}
