package uc.jpaexa2.service;

import java.util.List;

import uc.jpaexa2.entity.Categoria;



public interface CategoriaService {
	Categoria create(Categoria cat);
	Categoria update(Categoria cat);
	void delete(int idp);
	Categoria read(int idp);
	List<Categoria> readAll();
}
