package com.ringside.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.ringside.domain.Record;
import com.ringside.dto.RecordDTO;
import com.ringside.exceptions.RecordNotFoundException;
import com.ringside.repo.RecordRepo;

@Service
public class RecordService {
	private ModelMapper mapper;
	private RecordRepo repo;

	@Autowired
	public RecordService(RecordRepo repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

//	// Map to Dto
//	public RecordDTO mapToDTO(Record r) {
//		return this.mapper.map(r, RecordDTO.class);
//	}
//
//	// Map from Dto
//	public Record mapFromDTO(RecordDTO r) {
//		return this.mapper.map(r, Record.class);
//	}

	// Create for DTo
	public RecordDTO createDTO(RecordDTO r) {
		
		
		Record saveIt = this.mapper.map(r,Record.class);
		
		Record saved = this.repo.save(saveIt);
		return this.mapper.map(saved, RecordDTO.class);
	}
		
		

	// CREATE
	public Record create(Record r) {
		return this.repo.saveAndFlush(r);
	}

	// READ ALL
	public List<Record> readAllRecords() {
		return this.repo.findAll();
	}

	// READ ID
	public Record readId(Long id) {
		return this.repo.findById(id).get();
	}

	// DELETE
	public Boolean deleteId(Long id) {
		if (!this.repo.existsById(id)) {
			throw new RecordNotFoundException();
			// throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No Person found");
		}
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	// UPDATE
	public Record updateId(Record r, Long id) {
		Record exists = this.repo.findById(id).orElseThrow(RecordNotFoundException::new);
		// Record exists = this.repo.findById(id).orElseThrow();
		exists.setContender1(r.getContender1());
		exists.setContender2(r.getContender2());
		exists.setWinner(r.getWinner());
		exists.setFightDate(r.getFightDate());
		return this.repo.saveAndFlush(exists);
	}

	// Find by name
	public List<Record> findByName(String name) {

		return this.repo.findByName(name);
	}

}
