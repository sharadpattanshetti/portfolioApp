package com.nab.portfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nab.portfolio.entity.Contact;


/**
 * Repository class for contact entity
 * 
 * Created by Sharad
 */

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

}
