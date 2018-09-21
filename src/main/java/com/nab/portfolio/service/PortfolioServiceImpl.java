
package com.nab.portfolio.service;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.nab.portfolio.entity.Project;
import com.nab.portfolio.exception.ResourceNotFoundException;
import com.nab.portfolio.repository.ContactRepository;
import com.nab.portfolio.repository.ProjectRepository;

/**
 * Service Implementation class for Portfolio controller
 * 
 * Created by Sharad
 */


@Service
public class PortfolioServiceImpl implements PortfolioService {

	private static final Logger logger = LoggerFactory.getLogger(PortfolioServiceImpl.class);


	@Autowired
	ProjectRepository portfolioRepository;

	@Autowired
	ContactRepository contactRepository;

	public List<Project> getAllPortfolios() {
		List<Project> projects = (List<Project>) portfolioRepository.findAll();
		for (Project project : projects) {
			System.out.println(project.getContacts().size());

		}

		return projects;

	}

	public Project createPortfolio(@Valid @RequestBody Project project) {
		
		if(ValidateEstimates.validateFibonacci(project.getEstimates())){
			Project projectsaved = portfolioRepository.save(project);
			return projectsaved;
		}
		throw new IllegalArgumentException("Estimates value is invalid");
	}

	

	public Project getPortfolioById(@PathVariable(value = "id") Long projectId) {

		return portfolioRepository.findById(projectId)
				.orElseThrow(() -> new ResourceNotFoundException("Portfolio", "id", projectId));
		 
	}

	public Project updatePortfolioDetails(@PathVariable(value = "id") Long projectID, @Valid @RequestBody Project projDetails) {

		 Project project = portfolioRepository.findById(projectID)
				.orElseThrow(() -> new ResourceNotFoundException("Project", "id", projectID));

		project.setName(projDetails.getName());

		Project updatedProj =  portfolioRepository.save(project);
		return updatedProj;
	}

	public ResponseEntity<?> deletePortfolio(@PathVariable(value = "id") Long projId) {
		Project proj = portfolioRepository.findById(projId)
		.orElseThrow(() -> new ResourceNotFoundException("Proj", "id",
				projId));

		portfolioRepository.delete(proj);

		return ResponseEntity.ok().build();
	}

}
