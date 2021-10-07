package com.ringside.springtest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.ringside.repo.RecordRepo;
import com.ringside.service.RecordService;
import com.ringside.domain.Record;
import com.ringside.dto.RecordDTO;
import com.ringside.exceptions.RecordNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class RecordServiceTest {
//The class i will be testing
	@InjectMocks
	RecordService service;

//The class i will be mocking
	@Mock
	private RecordRepo repo;
	@Mock
	private ModelMapper mapper;

	@Test
	public void createTest() {
		Record input = new Record("Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(2002, 6, 8));
		Record output = new Record(1L, "Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(2002, 6, 8));

		// mocking the output from RecordRepo class
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);

		assertEquals(output, this.service.create(input));

		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
	}

	@Test
	public void readAllRecordsTest() {

		List<Record> output = Arrays.asList(
				new Record(1L, "Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(2002, 6, 8)),
				new Record(2L, "Anthony Joshua", "Oleksandr Usyk", "Aleksandr Usyk", LocalDate.of(2021, 9, 25)));

		// mocking the output from PersonRepo class
		Mockito.when(this.repo.findAll()).thenReturn(output);

		assertEquals(output, this.service.readAllRecords());

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void readIdTest() {

		Record input = new Record(1L, "Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(2002, 6, 8));

		// mocking the output from PersonRepo class
		Mockito.when(this.repo.findById(1L)).thenReturn(Optional.of(input));

		assertEquals(input, this.service.readId(1L));

		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	}

	@Test
	public void deleteIdSuccesTest() {

		Mockito.when(this.repo.existsById(1L)).thenReturn(true, false);

		assertTrue(this.service.deleteId(1L));

		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(2)).existsById(1L);

	}
	@Test
	public void deleteIdFailedTest() {

		Mockito.when(this.repo.existsById(1L)).thenReturn(true, true);

		assertFalse(this.service.deleteId(1L));

		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(2)).existsById(1L);

	}

	@Test(expected = RecordNotFoundException.class)
	public void deletedIdExceptionTest() {

		Mockito.when(this.repo.existsById(1L)).thenReturn(false);
		this.service.deleteId(1L);

		Mockito.verify(this.repo, Mockito.times(0)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(0)).existsById(1L);
	}

	@Test
	public void UpdateIdSuccesTest() {

		Record input = new Record(1L, "Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(2002, 6, 8));
		Long id = 1L;

		// mocking the output from PersonRepo class
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(input));
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(input);

		assertEquals(this.repo.saveAndFlush(input), this.service.updateId(input, id));

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(2)).saveAndFlush(input);

	}

	@Test(expected = RecordNotFoundException.class)
	public void UpdateIdFailedTest() {

		Record input = new Record(1L, "Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(2002, 6, 8));
		Long id = 1L;
		Optional<Record> exists = Optional.empty();

		// mocking the output from PersonRepo class
		Mockito.when(this.repo.findById(id)).thenReturn(exists);

		this.service.updateId(input, id);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);

	}

	@Test
	public void findByNameTest() {
		List<Record> output = Arrays
				.asList(new Record(1L, "Mike Tyson", "Lennox Lewis", "Lennox Lewis", LocalDate.of(2002, 6, 8)));

		Mockito.when(this.repo.findByName("Lennox Lewis")).thenReturn(output);
		assertEquals(this.repo.findByName("Lennox Lewis"), this.service.findByName("Lennox Lewis"));

	}
	@Test
	public void mapToDTOtest() {
		RecordDTO rDto = new RecordDTO(1L, "Mike Tyson", "Lennox Lewis","Lennox Lewis");
		Record input = new Record(1L, "Mike Tyson", "Lennox Lewis","Lennox Lewis",LocalDate.of(2002, 6, 8));
		
		Mockito.when(this.mapper.map(rDto,Record.class)).thenReturn(input);
		Mockito.when(this.repo.save(input)).thenReturn(input);
		Mockito.when(this.mapper.map(input,RecordDTO.class)).thenReturn(rDto);
		assertEquals(rDto, this.service.createDTO(rDto));
		
	
	}


}