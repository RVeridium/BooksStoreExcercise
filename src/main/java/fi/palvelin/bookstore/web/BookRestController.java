package fi.palvelin.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fi.palvelin.bookstore.domain.Book;
import fi.palvelin.bookstore.domain.BookRepository;
import fi.palvelin.bookstore.domain.Category;
import fi.palvelin.bookstore.domain.CategoryRepository;

@RestController
public class BookRestController {
	@Autowired
	private BookRepository repo;
	@Autowired
	private CategoryRepository repo2; 
	
	@GetMapping(value="/books")
	public List<Book> booklistREST () {
		return (List<Book>) repo.findAll(); 
		
	}
	
	@GetMapping(value="/books/{id}")
	public Optional<Book> Book (@PathVariable("id") Long bookId) {
		return repo.findById(bookId); 
	}
	
	@GetMapping(value="/categories")
	public List<Category> catlist () {
		return (List<Category>) repo2.findAll(); 
	}
	
	@GetMapping(value="/categories/{id}")
	public Optional<Category> Category (@PathVariable("id") Long cat) {
		return repo2.findById(cat); 
	}
	
	
	

}
