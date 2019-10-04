package com.crud.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Contact;
import com.crud.repository.ContactRepository;

@RestController /* contém as anotações @Controller e @ResponseBody (pode omitir essas duas para deixar o código mais limpo). */
@RequestMapping({"/contacts"}) /* indica que a URL da API desse controller começa com /contacts */
public class ContactController {
	
	private ContactRepository repository;
	
	ContactController(ContactRepository contactRepository){
		this.repository = contactRepository;
	}
	
	/* GET */
	@GetMapping
	public List findAll(){
	   return repository.findAll();
	}	
	
	/* GET POR ID */
	@GetMapping(path = {"/{id}"})
	public ResponseEntity findById(@PathVariable long id){
	   return repository.findById(id)
	           .map(record -> ResponseEntity.ok().body(record))
	           .orElse(ResponseEntity.notFound().build());
	}
	
	/* POST */
	@PostMapping
	public Contact create(@RequestBody Contact contact){ /*@RequestBody = o método espera receber um objeto (JSON)*/
	   return repository.save(contact);
	}
	
	/* PUT */
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") long id,
	                                      @RequestBody Contact contact) {
	   return repository.findById(id)
	           .map(record -> {
	               record.setName(contact.getName());
	               record.setEmail(contact.getEmail());
	               record.setPhone(contact.getPhone());
	               Contact updated = repository.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	/* DELETE */
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<?> delete(@PathVariable long id) {
	   return repository.findById(id)
	           .map(record -> {
	               repository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}
}
