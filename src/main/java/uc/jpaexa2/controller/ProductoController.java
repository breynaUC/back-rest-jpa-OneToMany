package uc.jpaexa2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uc.jpaexa2.entity.Producto;
import uc.jpaexa2.service.ProductoService;


@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private ProductoService productoService;
	@GetMapping("/all")
	public ResponseEntity<List<Producto>> getAlumnos(){
		try {
			List<Producto> list = new ArrayList<>();
			list = productoService.readAll();
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
	public ResponseEntity<Producto> save(@Validated @RequestBody Producto prod){
		try {
			Producto pro = productoService.create(prod);
			return new ResponseEntity<>(pro, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getproducto(@PathVariable("id") int id){
		Producto prod = productoService.read(id);
			if(prod.getId()>0) {
				return new ResponseEntity<>(prod, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			productoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Producto> update(@RequestBody Producto pr, @PathVariable("id") int id){
		try {
			Producto prod = productoService.read(id);
			if(prod.getId()>0) {
				prod.setNombre(pr.getNombre());
				prod.setPrecio(pr.getPrecio());
				prod.setStock(pr.getStock());
				prod.setCategoria(pr.getCategoria());
				return new ResponseEntity<>(productoService.create(prod),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
