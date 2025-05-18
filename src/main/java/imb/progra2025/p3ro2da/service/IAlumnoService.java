package imb.progra2025.p3ro2da.service;

import java.util.List;

import imb.progra2025.p3ro2da.dto.AlumnoRequestDTO;
import imb.progra2025.p3ro2da.entity.Alumno;

public interface IAlumnoService {
	
	public List<Alumno> findAll();
	public Alumno findById(Long id);
	public Alumno save(Alumno alumno);
	public void deleteById(Long id);
	public Alumno fromDto(AlumnoRequestDTO requestDto) throws Exception;

}
