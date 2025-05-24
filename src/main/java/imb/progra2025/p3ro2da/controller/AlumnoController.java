package imb.progra2025.p3ro2da.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.progra2025.p3ro2da.dto.AlumnoRequestDTO;
import imb.progra2025.p3ro2da.dto.ApiResponseDTO;
import imb.progra2025.p3ro2da.entity.Alumno;
import imb.progra2025.p3ro2da.service.IAlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	private IAlumnoService service;
	
	//GET
    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<Alumno>>> findAllAlumnos() {
        List<Alumno> alumnos = service.findAll();
        ApiResponseDTO<List<Alumno>> resp = new ApiResponseDTO<>(alumnos, "Lista de alumnos obtenida correctamente");
        return ResponseEntity.ok(resp);
    }
	
	//GET (por ID)
	@GetMapping("/{idalumno}")
	public ResponseEntity<ApiResponseDTO<Alumno>> findAlumnoById(@PathVariable("idalumno") Long id) {
		Alumno alumno = service.findById(id);
		ApiResponseDTO<Alumno> resp = new ApiResponseDTO<>(alumno, "Alumno con id " + id + " obtenido correctamente");
		return ResponseEntity.ok(resp);
	}
	
	//POST
	@PostMapping("/alumno")
	public ResponseEntity<Alumno> createAlumno(@RequestBody AlumnoRequestDTO alumnoRequestDto){
		return ResponseEntity.ok(service.create(service.fromDto(alumnoRequestDto))) ;
	}
	
	//PUT
	@PutMapping("/alumno/{idalumno}")
	public ResponseEntity<Alumno> updateAlumno(@PathVariable("idalumno") Long id, @RequestBody AlumnoRequestDTO alumnoRequestDto) {
		return ResponseEntity.ok(service.update(id, service.fromDto(alumnoRequestDto))) ;

	}
	
	//DELETE
	@DeleteMapping("/alumno/{idalumno}")
	public String deleteAlumno(@PathVariable("idalumno") Long id) {
		service.deleteById(id);
		return "Alumno " + id.toString() + " eliminado correctamente. ";
	}  
	

}
