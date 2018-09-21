package com.nab.portfolio;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.nab.portfolio.controller.PortfolioController;
import com.nab.portfolio.entity.Contact;
import com.nab.portfolio.entity.Project;
import com.nab.portfolio.entity.ProjectTypeMetadata;
import com.nab.portfolio.service.PortfolioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortfolioControllerTest {

	@Autowired
    protected WebApplicationContext wac;
	
	private MockMvc mockMvc;

	@Autowired
	PortfolioController portfolioController;
	
	@MockBean
	PortfolioService portfolioService;
	
	private List<Project> projects= new ArrayList<>();
	
	
	
	 @Before
	    public void setup() throws Exception {
	        this.mockMvc = standaloneSetup(this.portfolioController).build();// Standalone context
	        
	        Project project1 = new Project();
	        project1.setName("ProjectTest1");
	        project1.setDescription("ProjectTest1 Description");
	        project1.setSummary("ProjectTest1 Summary");
	        project1.setCritical(true);
	        project1.setEstimates(1);
	        project1.setTypeMetadata(ProjectTypeMetadata.DocsManagement);
	        Project project2 = new Project();
	        project2.setName("ProjectTest1");
	        project2.setDescription("ProjectTest1 Description");
	        project2.setSummary("ProjectTest1 Summary");
	        project2.setTypeMetadata(ProjectTypeMetadata.Securities_AND_Collateral);
	        
	        Contact contact = new Contact();
	        contact.setFirstName("Ryan");
	        contact.setLastName("D");
	        List<Contact>contacts = new ArrayList<>();
	        contacts.add(contact);
	        
	        project2.setContacts(contacts);
	        
	        
	        projects.add(project1);
	        projects.add(project2);
	        
	 }
	
	@Test
	public void getProjects() throws Exception {

		System.out.println("In Test case");
		//when(mangaService.getMangasByTitle(any(String.class))).thenReturn(mangas);
		when(portfolioService.getAllPortfolios()).thenReturn(projects);
		
		 mockMvc.perform(get("/api/portfolios").contentType(MediaType.APPLICATION_JSON))
         .andExpect(status().isOk())
         .andExpect(jsonPath("$[0].name", is("ProjectTest1")))
         .andExpect(jsonPath("$[1].description", is("ProjectTest1 Description")));
		
		
	}

}
