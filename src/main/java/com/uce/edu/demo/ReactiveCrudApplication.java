package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.uce.edu.demo.model.Persona;
import com.uce.edu.demo.service.PersonaService;

@SpringBootApplication
public class ReactiveCrudApplication implements CommandLineRunner{

	@Autowired
	private PersonaService personaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ReactiveCrudApplication.class, args);
	}
	


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
				// Crear una nueva persona
				Persona persona = new Persona();
				persona.setNombre("Kevin");
				persona.setDireccion("La Ecuatoriana");
				persona.setFechaNacimiento(LocalDateTime.of(2000, 2, 20, 0, 0));
				//persona.setId(1);
				
				personaService.createPersona(persona).subscribe();

				// Obtener una persona por su ID
				personaService.getPersonaByID(1)
					.subscribe(p -> System.out.println("Persona encontrada: " + p));

				// Obtener todas las personas
				personaService.getAllPersonas()
					.subscribe(p -> System.out.println("Persona encontrada: " + p));

				// Eliminar una persona por su ID
				personaService.deletePersonaById(1).subscribe();
		
	}

}
