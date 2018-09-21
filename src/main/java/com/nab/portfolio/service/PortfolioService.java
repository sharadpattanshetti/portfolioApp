/**
 * The Service class for the Portfolio information.  
 */
package com.nab.portfolio.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.nab.portfolio.entity.Project;

/**
 * Service interface class for Portfolio controller
 * 
 * @author sharad
 *
 */
public interface PortfolioService {
	
	public List<Project> getAllPortfolios();
	public Project createPortfolio(Project project);
	public Project getPortfolioById(Long projectId);
	public Project updatePortfolioDetails(Long projectID,Project projDetails);
	public ResponseEntity<?> deletePortfolio(Long projectId);
	

}
