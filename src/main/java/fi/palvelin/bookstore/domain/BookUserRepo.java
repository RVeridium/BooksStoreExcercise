package fi.palvelin.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookUserRepo extends CrudRepository<BookUser, Long> {
	BookUser findByUsername(String username); 

}
