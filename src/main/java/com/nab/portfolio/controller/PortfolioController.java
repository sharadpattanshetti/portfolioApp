package com.nab.portfolio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nab.portfolio.entity.Project;
import com.nab.portfolio.service.PortfolioService;


/**
 * Portfolio Controller class for all REST API requests.
 * 
 * Created by Sharad
 */

@RestController
@RequestMapping("/api")
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;
    
    @GetMapping("/portfolios")
    public List<Project> getAllPortfolios() {
    	return portfolioService.getAllPortfolios();
    	
    }
    
    @PostMapping("/portfolios")
    public Project createPortfolio(@Valid @RequestBody Project project) {
    	return portfolioService.createPortfolio(project);
    }
    
    @GetMapping("/portfolios/{id}")
    public Project getPortfolioById(@PathVariable(value = "id") Long portfolioId) {
    	return portfolioService.getPortfolioById(portfolioId);
    	
    }
    
    @PutMapping("/portfolios/{id}")
    public Project updatePortfolio(@PathVariable(value = "id") Long projId,
                                           @Valid @RequestBody Project ProjDetails) {
    	return portfolioService.updatePortfolioDetails(projId, ProjDetails);
    	
    }
    
    @DeleteMapping("/portfolios/{id}")
    public ResponseEntity<?> deletePortfolio(@PathVariable(value = "id") Long projectId) {        
        return portfolioService.deletePortfolio(projectId);
    }
}
