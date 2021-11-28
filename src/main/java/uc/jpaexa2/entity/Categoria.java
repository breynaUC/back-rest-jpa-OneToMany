package uc.jpaexa2.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="categorias")
public class Categoria implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 464894200054200010L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcategoria")	
	private int id;
	private String nombre;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "categoria", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Producto> productos = new ArrayList<>();

}
