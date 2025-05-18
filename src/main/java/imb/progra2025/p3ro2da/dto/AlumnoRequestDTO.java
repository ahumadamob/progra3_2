package imb.progra2025.p3ro2da.dto;

public class AlumnoRequestDTO {
	private String apellido;
	private String nombre;
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
