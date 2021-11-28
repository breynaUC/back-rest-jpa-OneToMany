package uc.jpaexa2.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="productos")
public class Producto implements Serializable{

	private static final long serialVersionUID = 3935380799899024530L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idproducto")
	private int id;
	private String nombre;
	private double precio;
	private int stock;
	
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinColumn(name = "categoria_id", referencedColumnName = "idcategoria")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Categoria categoria;

}
