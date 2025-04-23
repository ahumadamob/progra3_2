package imb.progra2025.p3ro2da.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.progra2025.p3ro2da.entity.Alumno;
import imb.progra2025.p3ro2da.service.AlumnoService;

@RestController
public class AlumnoController {
	
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping("/holamundo")
	public String holaMundo() {
		return "Hola Mundo";
	}
	
	@GetMapping("/unalumno")
	public Alumno unAlumno() {
		AlumnoService service = new AlumnoService();
		return service.obtenerUnAlumno();
	}
	

	@GetMapping("/arrayalumnos")
	public List<Alumno> arrayAlumnos() {
		return alumnoService.obtenerTodosDesdeLaBase();

	}	
	

	
	

}
