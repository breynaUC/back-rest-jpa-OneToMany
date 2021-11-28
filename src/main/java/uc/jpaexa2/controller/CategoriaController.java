package uc.jpaexa2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uc.jpaexa2.entity.Categoria;
import uc.jpaexa2.service.CategoriaService;



@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Categoria>> getAlumnos(){
		try {
			List<Categoria> list = new ArrayList<>();
			list = categoriaService.readAll();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/create")
	public ResponseEntity<Categoria> save(@RequestBody Categoria cat){
		try {
			Categoria c = new Categoria();
			c.setNombre(cat.getNombre());
			c.setProductos(null);
			Categoria al = categoriaService.create(c);
			return new ResponseEntity<>(al, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getUser(@PathVariable("id") int id){
		Categoria cat = categoriaService.read(id);
			if(cat.getId()>0) {
				return new ResponseEntity<>(cat, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			categoriaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Categoria> update(@RequestBody Categoria cat, @PathVariable("id") int id){
		try {
			Categoria categoria = categoriaService.read(id);
			if(cat.getId()>0) {
				categoria.setNombre(cat.getNombre());
				return new ResponseEntity<>(categoriaService.create(categoria),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

