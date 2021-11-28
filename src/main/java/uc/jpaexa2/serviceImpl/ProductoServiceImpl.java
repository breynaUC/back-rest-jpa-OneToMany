package uc.jpaexa2.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.jpaexa2.entity.Producto;
import uc.jpaexa2.repository.ProductoRepository;
import uc.jpaexa2.service.ProductoService;
@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public Producto create(Producto prod) {
		// TODO Auto-generated method stub
		return productoRepository.save(prod);
	}

	@Override
	public Producto update(Producto prod) {
		// TODO Auto-generated method stub
		return productoRepository.save(prod);
	}

	@Override
	public void delete(int idp) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(idp);
		
	}

	@Override
	public Producto read(int idp) {
		// TODO Auto-generated method stub
		return productoRepository.findById(idp).get();
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

}
