package imb.progra2025.p3ro2da.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra2025.p3ro2da.dto.AlumnoRequestDTO;
import imb.progra2025.p3ro2da.entity.Alumno;
import imb.progra2025.p3ro2da.entity.Curso;
import imb.progra2025.p3ro2da.exception.ResourceNotFoundException;
import imb.progra2025.p3ro2da.repository.AlumnoRepository;
import imb.progra2025.p3ro2da.repository.CursoRepository;
import imb.progra2025.p3ro2da.service.IAlumnoService;

@Service
public class AlumnoServiceImpl implements IAlumnoService {
	
	@Autowired
	private AlumnoRepository repo;
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public List<Alumno> findAll() {
		return repo.findAll();
	}

	@Override
	public Alumno findById(Long id) {
	    return repo.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con id " + id));
	}
	
	@Override
	public Alumno create(Alumno alumno) {
		return repo.save(alumno);
	}
	
	@Override
	public Alumno update(Long id, Alumno alumno) throws ResourceNotFoundException {
		if(repo.existsById(id)) {
			alumno.setId(id);
			return repo.save(alumno);
		}else {
			throw new ResourceNotFoundException("Alumno no encontrado con id " + id + ". Imposible actualizar");
		}
	}	

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);		
	}

	@Override
	public Alumno fromDto(AlumnoRequestDTO dto) throws ResourceNotFoundException {
	    Curso curso = cursoRepository.findById(dto.getCursoId())
	        .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con id " + dto.getCursoId()));

	    return new Alumno(dto.getApellido(), dto.getNombre(), curso);
	}

	@Override
	public boolean existsById(Long id) {
		return repo.existsById(id);
	}

}
