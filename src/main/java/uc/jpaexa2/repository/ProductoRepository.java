package uc.jpaexa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uc.jpaexa2.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
