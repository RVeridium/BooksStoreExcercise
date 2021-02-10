package fi.palvelin.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.palvelin.bookstore.domain.Book;
import fi.palvelin.bookstore.domain.BookRepository;
import fi.palvelin.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repo;
	@Autowired
	private CategoryRepository repo2; 
	
	@RequestMapping(value="/booklist") 
	public String allBooks(Model model) {
		model.addAttribute("books", repo.findAll()); 
		return "booklist"; 
	}
	
	 @RequestMapping(value = "/add")
	    public String addBook(Model model){
	    	model.addAttribute("book", new Book());
	    	model.addAttribute("categories", repo2.findAll()); 
	        return "newbook";
	    }  
	 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Book book){
	        repo.save(book);
	        return "redirect:booklist";
	    }
	 
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	    	repo.deleteById(bookId);
	        return "redirect:../booklist";
	    }
	 
	 @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	 	public String editBook(@PathVariable("id") long bookId, Model model) {
		 model.addAttribute("book", repo.findById(bookId).get()); 
		 model.addAttribute("categories", repo2.findAll());
		 return "editbook"; 
	 }
	 
	 @RequestMapping(value = "edit/update/{id}", method = RequestMethod.POST)
	    public String update(Book book, Model model) {
		 repo.save(book); 
		 //model.addAttribute("books", repo.findAll()); 
	     return "redirect:/booklist";
	    }
	    /*
	     @RequestMapping(value = "edit/save", method = RequestMethod.POST)
	    public String save2(Book book){
	        repo.save(book);
	        return "redirect:booklist";
	    }
	    */
}
