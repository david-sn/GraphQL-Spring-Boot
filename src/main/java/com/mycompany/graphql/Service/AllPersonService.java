/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graphql.Service;

import com.mycompany.graphql.Repository.PersonRepository;
import com.mycompany.graphql.entity.Person;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author D.Nazer
 */
@Service
public class AllPersonService implements DataFetcher<List<Person>> {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> get(DataFetchingEnvironment dfe) {
        return personRepository.findAll();
    }

}
