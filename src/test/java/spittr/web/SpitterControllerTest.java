package spittr.web;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import spittr.Spitter;
import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;
import spittr.web.SpitterController;
public class SpitterControllerTest {
	@Test
	public void shouldShowRegistration() throws Exception {
		SpitterRepository mockRepository = mock(SpitterRepository.class);
	    SpitterController controller = new SpitterController(mockRepository);
	    MockMvc mockMvc = standaloneSetup(controller).build();
	    mockMvc.perform(get("/spitter/register"))
	           .andExpect(view().name("registerForm"));
	}
	
	@Test
	public void shouldProcessRegistration() throws Exception {
		SpitterRepository mockRespository = mock(SpitterRepository.class);
		Spitter unsavede = new Spitter("Jack","Bauer","jbauer","24hours");
		Spitter saved = new Spitter(24L,"Jack","Bauer","jbauer","24hours");
		when(mockRespository.save(unsavede)).thenReturn(saved);
		
		SpitterController controller = new SpitterController(mockRespository);
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(post("/spitter/register")
		           .param("firstName", "Jack")
		           .param("lastName", "Bauer")
		           .param("userName", "jbauer")
		           .param("password", "24hours"))
		           .andExpect(redirectedUrl("/spitter/jbauer"));
		
		 verify(mockRespository, atLeastOnce()).save(unsavede);
	}

}
