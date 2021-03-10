package fi.palvelin.bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.palvelin.bookstore.domain.Book;
import fi.palvelin.bookstore.domain.BookRepository;
import fi.palvelin.bookstore.domain.Category;
import fi.palvelin.bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository bookrepo; 
	
	@Autowired
	private CategoryRepository catrepo; 
	
	
	@Test
	public void insertBook() throws Exception {
		Category cat = new Category("Thriller"); 
		catrepo.save(cat); 
		Book book = new Book("Die another day TEST", "J. Bond", "1353203-66", 2003, 31.3, catrepo.findByName("Thriller").get(0)); 
		bookrepo.save(book);
		assertThat(book.getId()).isNotNull(); 	
	}
	
	@Test
	public void deleteBook() throws Exception {
		Category cat = new Category("Action"); 
		catrepo.save(cat); 
		Book book = new Book("Die another day remove", "J. Bonder", "1353203-66", 2003, 31.3, catrepo.findByName("Action").get(0)); 
		bookrepo.save(book);
		assertThat(book.getId()).isNotNull();
		bookrepo.deleteById(book.getId());
		assertThat(bookrepo.findByAuthor("J. Bonder")).isEmpty();
	}
	

}
