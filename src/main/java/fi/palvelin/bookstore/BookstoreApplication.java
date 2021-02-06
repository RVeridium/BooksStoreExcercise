package fi.palvelin.bookstore;

import org.springframework.boot.CommandLineRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.palvelin.bookstore.domain.Book;
import fi.palvelin.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository){
		
		return(args)-> {
			log.info("Adding books to db"); 
			repository.save(new Book("The Expanse", "J. S. Corey", "12302564-2", 1998, 23.70));
			repository.save(new Book("Relevation Space", "Higgins", "12303564-1", 1989, 20.30));
			log.info("Fetch all: ");
			for (Book book: repository.findAll()) {
				log.info(book.toString());
			}; 
		}; 	
	}

}
