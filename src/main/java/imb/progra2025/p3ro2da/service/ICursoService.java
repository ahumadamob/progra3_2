package imb.progra2025.p3ro2da.service;

import java.util.List;

import imb.progra2025.p3ro2da.entity.Curso;

public interface ICursoService {
	public List<Curso> findAll();
	public Curso findById(Long id);
	public Curso save(Curso curso);
	public void deleteById(Long id);
}
