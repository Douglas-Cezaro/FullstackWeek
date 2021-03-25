package br.com.douglascezaro.fullstackweek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.douglascezaro.fullstackweek.domain.PriorityGroups;

public interface PriorityGroupsRepository  extends JpaRepository<PriorityGroups, Long>{

}
