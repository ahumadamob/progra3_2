package imb.progra2025.p3ro2da.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import imb.progra2025.p3ro2da.dto.AlumnoRequestDTO;
import imb.progra2025.p3ro2da.entity.Alumno;
import imb.progra2025.p3ro2da.entity.Curso;
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

	public Alumno findById(Long id) {
		Optional<Alumno> opt;
		opt = repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}

	@Override
	public Alumno create(Alumno alumno) {
		return repo.save(alumno);
	}
	
	@Override
	public Alumno update(Long id, Alumno alumno) throws Exception {
		if(repo.existsById(id)) {
			alumno.setId(id);
			return repo.save(alumno);
		}else {
			throw new Exception("Alumno no encontrado");
		}
	}	

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);		
	}

	@Override
	public Alumno fromDto(AlumnoRequestDTO dto) throws Exception {
	    Curso curso = cursoRepository.findById(dto.getCursoId())
	        .orElseThrow(() -> new Exception("Curso no encontrado"));

	    return new Alumno(dto.getApellido(), dto.getNombre(), curso);
	}

	@Override
	public boolean existsById(Long id) {
		return repo.existsById(id);
	}

}
