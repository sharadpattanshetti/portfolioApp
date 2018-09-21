package com.nab.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nab.portfolio.entity.Project;


/**
 * Repository class for project entity
 * 
 * Created by Sharad
 */

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

}
