package uc.jpaexa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uc.jpaexa2.entity.Categoria;

@Repository
public interface CategoriaRepositary extends JpaRepository<Categoria, Integer>{

}
