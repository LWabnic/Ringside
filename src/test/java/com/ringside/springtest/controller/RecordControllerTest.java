package com.ringside.springtest.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ringside.service.RecordService;
import com.ringside.domain.Record;
import com.ringside.exceptions.RecordNotFoundException;

@RunWith(SpringRunner.class)
@WebMvcTest
public class RecordControllerTest {
	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	@MockBean
	RecordService service;

	@Test
	public void createTest() throws Exception {
		Record r = new Record(1L, "Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(2002, 6, 8));
		String rAsJson = this.mapper.writeValueAsString(r);

		Mockito.when(this.service.create(r)).thenReturn(r);

		mvc.perform(post("/record/createR").contentType(MediaType.APPLICATION_JSON).content(rAsJson))
				.andExpect(status().isCreated()).andExpect(content().json(rAsJson));
	}

	@Test
	public void readAllRTest() throws Exception {
		List<Record> r = Arrays.asList(
				new Record(1L, "Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(2002, 6, 8)),
				new Record(2L, "Anthony Joshua", "Oleksandr Usyk", "Aleksandr Usyk", LocalDate.of(2021, 9, 25)));
		String rAsJson = this.mapper.writeValueAsString(r);

		Mockito.when(this.service.readAllRecords()).thenReturn(r);

		mvc.perform(get("/record/readR")).andExpect(status().isOk()).andExpect(content().json(rAsJson));

	}

	@Test
	public void readRTest() throws Exception {
		Record r = new Record(1L, "Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(2002, 6, 8));
		String rAsJson = this.mapper.writeValueAsString(r);

		Mockito.when(this.service.readId(1L)).thenReturn(r);

		mvc.perform(get("/record/readR/1")).andExpect(status().isOk()).andExpect(content().json(rAsJson));

	}

	@Test
	public void updateRTest() throws Exception {
		Record r = new Record(1L, "Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(2002, 6, 8));
		String rAsJson = this.mapper.writeValueAsString(r);

		Mockito.when(this.service.updateId(r, 1L)).thenReturn(r);

		mvc.perform(put("/record/updateR/1").contentType(MediaType.APPLICATION_JSON).content(rAsJson))
				.andExpect(status().isAccepted()).andExpect(content().json(rAsJson));

	}

	@Test
	public void deleteRSuccesTest() throws Exception {

		Mockito.when(this.service.deleteId(1L)).thenReturn(true);

		mvc.perform(delete("/record/deleteR/1")).andExpect(status().isNoContent());

	}

	@Test()
	public void deleteRFailTest() throws Exception {

		RecordNotFoundException ex = new RecordNotFoundException();

		Mockito.when(this.service.deleteId(1L)).thenThrow(ex);

		mvc.perform(delete("/record/deleteR/1")).andExpect(status().isNotFound())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof RecordNotFoundException))
				.andExpect(result -> assertEquals(null, result.getResolvedException().getMessage()));

	}

	@Test
	public void findByNameTest() throws Exception {
		List<Record> r = Arrays
				.asList(new Record(1L, "Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(2002, 6, 8)));
		String rAsJson = this.mapper.writeValueAsString(r);

		Mockito.when(this.service.findByName("Lennox%20Lewis")).thenReturn(r);

		mvc.perform(get("/record/readname/Lennox%20Lewis")).andExpect(status().isOk())
				.andExpect(content().json(rAsJson));

	}

}