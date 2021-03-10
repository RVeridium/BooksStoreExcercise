package fi.palvelin.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findByAuthor(String name); 
	//void updateById(Long id, Book book); 
	Book findByTitle(String title); 
	

}
