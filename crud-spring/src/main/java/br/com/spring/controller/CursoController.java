package br.com.spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.model.Curso;
import br.com.spring.repository.CursoRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cursos")
@AllArgsConstructor
public class CursoController {
	
	
	private final CursoRepository cursoRepository;
	
	
	/*@RequestMapping(method = RequestMethod.GET) OU @GetMapping -> 
	 * Duas anotações que fazem a mesma requisição para o método GET*/
	@GetMapping
	public @ResponseBody List<Curso> list() {
		return cursoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Curso> create(@RequestBody Curso curso) {
		//System.out.println(curso.getNome());
		//return cursoRepository.save(curso);
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoRepository.save(curso));
	}
}
