package imb.progra2025.p3ro2da.service;

import java.util.List;

import imb.progra2025.p3ro2da.dto.AlumnoRequestDTO;
import imb.progra2025.p3ro2da.entity.Alumno;
import imb.progra2025.p3ro2da.exception.ResourceNotFoundException;

public interface IAlumnoService {
	
	public List<Alumno> findAll();
	public Alumno findById(Long id) throws ResourceNotFoundException;
	public Alumno create(Alumno alumno);
	public Alumno update(Long id, Alumno alumno) throws ResourceNotFoundException;
	public void deleteById(Long id);
	public Alumno fromDto(AlumnoRequestDTO requestDto) throws ResourceNotFoundException;
	public boolean existsById(Long id);

}
