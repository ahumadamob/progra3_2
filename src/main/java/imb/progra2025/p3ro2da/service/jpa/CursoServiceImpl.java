package imb.progra2025.p3ro2da.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.progra2025.p3ro2da.entity.Curso;
import imb.progra2025.p3ro2da.repository.CursoRepository;
import imb.progra2025.p3ro2da.service.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService {
	
	@Autowired
	private CursoRepository repo;

	@Override
	public List<Curso> findAll() {
		return repo.findAll();
	}

	@Override
	public Curso findById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Curso save(Curso curso) {
		return repo.save(curso);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

}
