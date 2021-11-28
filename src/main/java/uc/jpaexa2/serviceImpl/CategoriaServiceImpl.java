package uc.jpaexa2.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.jpaexa2.entity.Categoria;
import uc.jpaexa2.repository.CategoriaRepositary;
import uc.jpaexa2.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepositary categoriaRepository;
	@Override
	public Categoria create(Categoria cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria update(Categoria cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int idp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categoria read(int idp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> readAll() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

}
