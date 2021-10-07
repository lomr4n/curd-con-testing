package com.example.ejercicio.crud;

import com.example.ejercicio.crud.Persona.domain.Persona;
import com.example.ejercicio.crud.Persona.infrastructure.repository.PersonaRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@org.springframework.boot.test.context.SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpringBootTesting {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PersonaRepository personaRepository;

	@BeforeAll
	void start() {
		Persona persona = new Persona();
		persona.setId(1L);
		persona.setUser("Javier");
		persona.setSurname("Marmol");
		persona.setPersonal_email("javier.marmol@gmail.com");
		persona.setCompany_email("javier.marmol@bosonit.com");
		persona.setPassword("1234");
		persona.setActive(true);
		persona.setCity("Logroño");
		persona.setImagen_url("https://googles.es");
		personaRepository.save(persona);
	}
	@Test
	@DisplayName("Testeando el getAll del PersonaController")
	void getAllTest() throws Exception {
		MvcResult result  = this.mockMvc.perform(get("/api/v1/personas")).andExpect(status().isOk()).andReturn();
		String content= result.getResponse().getContentAsString();


		List<Persona> personas= new ObjectMapper().readValue(content, new TypeReference<List<Persona>>() {   });
		Assertions.assertEquals(personas.get(0).getUser(),"Javier");
	}
	@Test
	@DisplayName("Testeando el getOneById del PersonaController")
	void getOneTest() throws Exception {
		MvcResult result  = this.mockMvc.perform(get("/api/v1/personas/1")).andExpect(status().isOk()).andReturn();
		String content= result.getResponse().getContentAsString();


		Persona persona= new ObjectMapper().readValue(content, new TypeReference<Persona>() {   });
		Assertions.assertEquals(persona.getUser(),"Javier");
	}
	@Test
	@DisplayName("Testeando el save del PersonaController")
	void saveTest() throws Exception {
		MvcResult result  = this.mockMvc.perform(post("/api/v1/personas")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"user\": \"saveTest\"," +
						"\"password\": \"1234\",\"surname\": \"apellido\"," +
						"\"company_email\": \"1@1.com\",\"personal_email\": " +
						"\"2@2.com\",\"city\": \"logroño\",\"active\": true,\"imagen_url\": " +
						"\"https://googles.es\"}")).andDo(print())
				.andExpect(status().is2xxSuccessful()).andReturn();
		String content= result.getResponse().getContentAsString();


		Persona persona= new ObjectMapper().readValue(content, new TypeReference<Persona>() {   });
		Assertions.assertEquals(persona.getUser(),"saveTest");
	}
	@Test
	@DisplayName("Testeando el update del PersonaController")
	void updateTest() throws Exception {
		MvcResult result  = this.mockMvc.perform(put("/api/v1/personas/2")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"user\": \"updateTest\"," +
						"\"password\": \"1234\",\"surname\": \"apellido\"," +
						"\"company_email\": \"1@1.com\",\"personal_email\": " +
						"\"2@2.com\",\"city\": \"logroño\",\"active\": true,\"imagen_url\": " +
						"\"https://googles.es\"}")).andDo(print())
				.andExpect(status().is2xxSuccessful()).andReturn();
		String content= result.getResponse().getContentAsString();


		Persona persona= new ObjectMapper().readValue(content, new TypeReference<Persona>() {   });
		Assertions.assertEquals(persona.getUser(),"updateTest");
	}
	@Test
	@DisplayName("Testeando el delete del PersonaController")
	void deleteTest() throws Exception {
		MvcResult result  = this.mockMvc.perform(delete("/api/v1/personas/1")).andExpect(status().is2xxSuccessful()).andReturn();
		String content= result.getResponse().getContentAsString();


		Boolean bool= new ObjectMapper().readValue(content, new TypeReference<Boolean>() {   });
		Assertions.assertTrue(bool);
	}
}
