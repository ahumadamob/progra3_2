package imb.progra2025.p3ro2da.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AlumnoRequestDTO {
	
	@NotBlank(message = "El apellido no puede estar vacio")
	private String apellido;
	
	@NotBlank(message = "El nombre no puede estar vacio")
	private String nombre;
	
	@NotNull(message = "El id de curso es obligatorio")
	private Long cursoId;
	
	public AlumnoRequestDTO(String apellido, String nombre, Long cursoId) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.cursoId = cursoId;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCursoId() {
		return cursoId;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}
	
	
	
}
