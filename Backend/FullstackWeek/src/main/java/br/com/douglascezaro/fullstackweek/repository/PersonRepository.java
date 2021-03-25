package br.com.douglascezaro.fullstackweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.douglascezaro.fullstackweek.domain.Person;

public interface PersonRepository  extends JpaRepository<Person, Long> {

}
