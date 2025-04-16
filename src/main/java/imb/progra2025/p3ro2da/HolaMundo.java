package imb.progra2025.p3ro2da;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {
	
	@GetMapping("/holamundo")
	public String holaMundo() {
		return "Hola Mundo";
	}
	
	@GetMapping("/unalumno")
	public Alumno unAlumno() {
		Alumno alumno = new Alumno();
		alumno.setId((long) 1);
		alumno.setApellido("Sanchez");
		alumno.setNombre("Laura");		
		return alumno;		
	}
	
	@GetMapping("/variosalumnos")
	public List<Alumno> variosAlumnos() {	
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		Alumno alumno1 = new Alumno();
		alumno1.setId((long) 1);
		alumno1.setApellido("Sanchez");
		alumno1.setNombre("Laura");
		
		Alumno alumno2 = new Alumno();
		alumno2.setId((long) 2);
		alumno2.setApellido("Martinez");
		alumno2.setNombre("Jorge");	
		
		Alumno alumno3 = new Alumno();
		alumno3.setId((long) 3);
		alumno3.setApellido("Guttierrez");
		alumno3.setNombre("Lucas");
		
		alumnos.add(alumno1);
		alumnos.add(alumno2);
		alumnos.add(alumno3);
		
		return alumnos;
	}
	
	

}
