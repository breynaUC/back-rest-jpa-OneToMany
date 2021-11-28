package uc.jpaexa2.service;

import java.util.List;

import uc.jpaexa2.entity.Producto;

public interface ProductoService {

	Producto create(Producto prod);
	Producto update(Producto prod);
	void delete(int idp);
	Producto read(int idp);
	List<Producto> readAll();
}
