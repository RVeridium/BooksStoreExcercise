package fi.palvelin.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User; 
import org.springframework.stereotype.Service;

import fi.palvelin.bookstore.domain.BookUser;
import fi.palvelin.bookstore.domain.BookUserRepo;

@Service
public class UserDetailServiceImp implements UserDetailsService {
	
	private final BookUserRepo repository;

	@Autowired
	public UserDetailServiceImp(BookUserRepo repository) {
		this.repository = repository;
	}   
	
	
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   
	    	BookUser curruser = repository.findByUsername(username);
	        UserDetails user = new User(username, curruser.getPwHashed(), 
	        		AuthorityUtils.createAuthorityList(curruser.getRole()));
	        return user;
	    }

	

}
