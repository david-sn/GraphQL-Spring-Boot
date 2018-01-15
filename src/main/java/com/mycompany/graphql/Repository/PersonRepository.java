/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graphql.Repository;

import com.mycompany.graphql.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author D.Nazer
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
