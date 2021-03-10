package fi.palvelin.bookstore;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fi.palvelin.bookstore.web.BookController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {
	@Autowired
	private MockMvc mockMvc; 
	
	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new BookController()).build();
	}
	
	@Test
	public void seeIndexPage() throws Exception {
		this.mockMvc.perform(get("/booklist"))
		.andExpect(status().isOk())
		.andExpect(view().name("booklist"))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}
	
	@Test
	public void seeAddPage() throws Exception {
		this.mockMvc.perform(get("/add"))
		.andExpect(status().isOk())
		.andExpect(view().name("newbook"))
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}
	
	
	
	

}
