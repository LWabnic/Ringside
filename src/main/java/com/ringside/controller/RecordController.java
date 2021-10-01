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
//	private List<Person> list = new ArrayList<>();

//	@GetMapping("/readAllStart")
//	public ResponseEntity<List<Person>> manualRead(){
//		return new ResponseEntity<List<Person>>(this.service.readAll(),HttpStatus.OK);
//	}
//	  @PostMapping("/createService")
//	    public boolean addPersonService(@RequestBody Person person) {
//	        return this.service.addPerson(person);
//	    }
//	
//	@GetMapping("/hello")
//	public String helloWorld() {
//		return "Hello World";
//	}
//
//	
//	@GetMapping("/get")
//	public Person get() {
//		return new Person(1L, "Bob", "Bobson");
//	}
//
//	@GetMapping("/getPersons")
//
//	public List<Person> getPersons() {
//		List<Person> list = Arrays.asList(new Person(1L, "Bob", "Bobson"), new Person(2L, "Rob", "Robson"));
//		return list;
//	}
//
//	@GetMapping("/getAll")
//	public List<Person> getAll() {
//		return this.list;
//	}
//
//	@GetMapping("/readAll")
//	public ResponseEntity<List<Person>> readAll() {
//		return new ResponseEntity<List<Person>>(this.list, HttpStatus.OK);
//	}

//	@PostMapping("/create")
//	public Person create(@RequestBody Person p) {
//		return new Person(p.getFirstName(),p.getLastName());
//	}
//	
//	@PostMapping("/create")
//	public boolean addPerson(@RequestBody Person person) {
//		return this.list.add(person);
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public Person removePerson(@PathVariable int id) {
//		// Remove Person and return it
//		return this.list.remove(id);
//	}
//
//	
//	@PostMapping("/creation")
//	public ResponseEntity<Person> creation(@RequestBody Person person){
//		return this.list.add(person)? new ResponseEntity<>(HttpStatus.ACCEPTED):
//			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);}
//	
//	@PostMapping("/deletion/{id}")
//	public ResponseEntity<Person> deletion(@PathVariable int id){
//		return this.list.remove(id) != null? new ResponseEntity<>(HttpStatus.NO_CONTENT):
//			new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);}
//
//    
//    
//	@GetMapping("/get/{id}")
//    public ResponseEntity<Person> getUser(@PathVariable int id) {
//        return new ResponseEntity<Person>(this.list.get(id), HttpStatus.OK);
//    }

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
