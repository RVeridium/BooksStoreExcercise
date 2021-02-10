package fi.palvelin.bookstore.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long catId; 
	
	private String name; 
	@OneToMany (cascade = CascadeType.ALL, mappedBy ="category")
	private List<Book> lista;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String name) {
		super();
		this.name = name;
		this.lista = new ArrayList<>(); 
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getLista() {
		return lista;
	}

	public void setLista(List<Book> lista) {
		this.lista = lista;
	} 
	
	
	
	

}
