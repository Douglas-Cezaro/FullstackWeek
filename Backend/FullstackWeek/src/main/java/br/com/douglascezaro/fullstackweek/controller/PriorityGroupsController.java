package br.com.douglascezaro.fullstackweek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.douglascezaro.fullstackweek.domain.PriorityGroups;
import br.com.douglascezaro.fullstackweek.repository.PriorityGroupsRepository;

@RestController
@RequestMapping("/priority-groups")
public class PriorityGroupsController {

	@Autowired
	private PriorityGroupsRepository priorityGroupsRepository;

	@GetMapping
	public List<PriorityGroups> getAll() {
		return priorityGroupsRepository.findAll();
	}

	@GetMapping("/{code}")
	public PriorityGroups findById(@PathVariable Long code) {
		return priorityGroupsRepository.findById(code).orElse(null);
	}

}
