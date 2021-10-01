package com.ringside.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ringside.domain.Record;
import com.ringside.service.RecordService;

@RequestMapping("/record")
@RestController
public class RecordController {

	@Autowired
	private RecordService service;

	// Create
	@PostMapping("/createR")
	public ResponseEntity<Record> createR(@RequestBody Record r) {
		return new ResponseEntity<Record>(this.service.create(r), HttpStatus.CREATED);
	}

	// Read
	@GetMapping("/readR")
	public ResponseEntity<List<Record>> readAllR() {
		return new ResponseEntity<List<Record>>(this.service.readAllRecords(), HttpStatus.OK);
	}

	// Read id
	@GetMapping("/readR/{id}")
	public ResponseEntity<Record> readR(@PathVariable Long id) {
		return new ResponseEntity<Record>(this.service.readId(id), HttpStatus.OK);
	}

	// Update
	@PutMapping("/updateR/{id}")
	public ResponseEntity<Record> updateR(@PathVariable Long id, @RequestBody Record r) {
		return new ResponseEntity<Record>(this.service.updateId(r, id), HttpStatus.ACCEPTED);
	}

	// Delete
	@DeleteMapping("/deleteR/{id}")
	public ResponseEntity<Boolean> deleteR(@PathVariable Long id) {
		return new ResponseEntity<Boolean>(this.service.deleteId(id), HttpStatus.NO_CONTENT);
	}
	//Find by name
	@GetMapping("/readname/{name}")
	public ResponseEntity<List<Record>>findByName(@PathVariable String name){
		return new ResponseEntity<List<Record>>(this.service.findByName(name),HttpStatus.OK);
	}
//	//create
//	@PostMapping("/createDTO")
//	public ResponseEntity<PersonDTO>createDTO(@RequestBody PersonDTO p){
//		return new ResponseEntity<PersonDTO>(this.service.createDTO(p),HttpStatus.CREATED);
//	}
}
