package imb.progra2025.p3ro2da.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import imb.progra2025.p3ro2da.entity.Curso;
import imb.progra2025.p3ro2da.service.ICursoService;

@RestController
public class CursoController {
	
	@Autowired
	private ICursoService service;
	
	//GET
	@GetMapping("/curso")
	public List<Curso> findAllCursos(){
		return service.findAll();
	}
	
	
	//GET (por ID)
	@GetMapping("/curso/{idcurso}")
	public Curso findCursoById(@PathVariable("idcurso") Long id) {
		return service.findById(id);
	}
	
	//POST
	@PostMapping("/curso")
	public Curso createCurso(@RequestBody Curso curso) {
		return service.save(curso);
		
	}
	
	//PUT
	@PutMapping("/curso")
	public Curso updateCurso(@RequestBody Curso curso) {
		return service.save(curso);
	}
	
	//DELETE
	@DeleteMapping("/curso/{idcurso}")
	public String deleteCurso(@PathVariable("idcurso") Long id) {
		service.deleteById(id);
		return "Curso " + id.toString() + " eliminado correctamente. ";
	}
}
