package imb.progra2025.p3ro2da.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import imb.progra2025.p3ro2da.dto.AlumnoRequestDTO;
import imb.progra2025.p3ro2da.entity.Alumno;
import imb.progra2025.p3ro2da.service.IAlumnoService;

@RestController
public class AlumnoController {
	
	@Autowired
	private IAlumnoService service;
	
	//GET
	@GetMapping("/alumno")
	public ResponseEntity<List<Alumno>> findAllAlumnos(){
		List<Alumno> alumnos = service.findAll();
		if(alumnos.isEmpty()) {
			return ResponseEntity.ok(alumnos);
		}else {
			return ResponseEntity.noContent().build();
		}
	}	
	
	//GET (por ID)
	@GetMapping("/alumno/{idalumno}")
	public ResponseEntity<Alumno> findAlumnoById(@PathVariable("idalumno") Long id) {
		if(service.existsById(id)) {
			return ResponseEntity.ok(service.findById(id));
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//POST
	@PostMapping("/alumno")
	public ResponseEntity<Alumno> createAlumno(@RequestBody AlumnoRequestDTO alumnoRequestDto) throws Exception {
		return ResponseEntity.ok(service.create(service.fromDto(alumnoRequestDto))) ;
	}
	
	//PUT
	@PutMapping("/alumno/{idalumno}")
	public ResponseEntity<Alumno> updateAlumno(@PathVariable("idalumno") Long id, @RequestBody AlumnoRequestDTO alumnoRequestDto) throws Exception {
		return ResponseEntity.ok(service.update(id, service.fromDto(alumnoRequestDto))) ;

	}
	
	//DELETE
	@DeleteMapping("/alumno/{idalumno}")
	public String deleteAlumno(@PathVariable("idalumno") Long id) {
		service.deleteById(id);
		return "Alumno " + id.toString() + " eliminado correctamente. ";
	}	
	
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage()) ;
    }	
	

}
