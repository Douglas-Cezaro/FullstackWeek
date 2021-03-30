package br.com.douglascezaro.fullstackweek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.douglascezaro.fullstackweek.domain.Person;
import br.com.douglascezaro.fullstackweek.repository.PersonRepository;

@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
	private PersonRepository personRepository; 
	
	@GetMapping
	public List<Person> getAll() {
		return personRepository.findAll();
	}
	
	@PostMapping
	public Person createPerson(@RequestBody Person person) {
		Person personCad = personRepository.save(person);
		personCad.setIsVaccinated(false);
		return personRepository.save(person);
	}
	
	@PutMapping("{code}")
	public Person update(@PathVariable ("code") Long code, @RequestBody Person person) {
		return personRepository.findById(code).map(
				record -> {
					record.setCpf(person.getCpf());
					record.setName(person.getName());
					record.setBirthDate(person.getBirthDate());
					record.setPhone(person.getPhone());
					record.setEmail(person.getEmail());
					record.setAge(person.getAge());
					record.setIsVaccinated(person.getIsVaccinated());
					
					return personRepository.save(record);
				}
				).orElse(null);
	}
	
	@GetMapping("{code}")
	public Person findByCode(@PathVariable ("code") Long code) {
		return personRepository.findById(code).orElse(null);
	}

}
