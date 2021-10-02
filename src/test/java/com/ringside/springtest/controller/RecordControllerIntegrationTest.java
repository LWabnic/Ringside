package com.ringside.springtest.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ringside.domain.Record;
import com.ringside.exceptions.RecordNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class RecordControllerIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void createTest() throws Exception {
		Record entry = new Record("Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(1999,8,9));
		Record result = new Record(2L, "Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(1999,8,9));
		
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(post("/record/createR")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(resultAsJSON));	
	}
	@Test
	public void readAllRTest() throws Exception {
		List<Record> r = Arrays.asList(
				new Record(1L, "Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(1999,8,9)));
		String rAsJson = this.mapper.writeValueAsString(r);

		mvc.perform(get("/record/readR")).andExpect(status().isOk()).andExpect(content().json(rAsJson));

	}
	@Test
	public void readRTest() throws Exception {
		Record r = new Record(1L,"Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(1999,8,9));
		String rAsJson = this.mapper.writeValueAsString(r);

		mvc.perform(get("/record/readR/1")).andExpect(status().isOk()).andExpect(content().json(rAsJson));

	}
	@Test
	public void updateRTest() throws Exception {
		Record r = new Record(1L,"Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(2002, 6, 8));
		String rAsJson = this.mapper.writeValueAsString(r);


		mvc.perform(put("/record/updateR/1").contentType(MediaType.APPLICATION_JSON).content(rAsJson))
				.andExpect(status().isAccepted()).andExpect(content().json(rAsJson));

	}
	
	@Test
	public void deleteRSuccesTest() throws Exception {


		mvc.perform(delete("/record/deleteR/1")).andExpect(status().isNoContent());

	}
	
	@Test()
	public void deleteRFailTest() throws Exception {


		mvc.perform(delete("/record/deleteR/2")).andExpect(status().isNotFound())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof RecordNotFoundException))
				.andExpect(result -> assertEquals(null, result.getResolvedException().getMessage()));

	}
	
	@Test
	public void findByNameTest() throws Exception {
		List<Record> r = Arrays
				.asList(new Record(1L, "Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(1999,8,9)));
		String rAsJson = this.mapper.writeValueAsString(r);

		mvc.perform(get("/record/readname/Lennox Lewis")).andExpect(status().isOk())
				.andExpect(content().json(rAsJson));

	}
}
