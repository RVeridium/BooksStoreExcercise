package fi.palvelin.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	Long getIdByName(String name); 
	List<Category> findByName(String name); 

}
