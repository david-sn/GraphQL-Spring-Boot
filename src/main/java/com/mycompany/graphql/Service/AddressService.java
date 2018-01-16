/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graphql.Service;

import com.mycompany.graphql.Repository.AddressRepository;
import com.mycompany.graphql.entity.Address;
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
public class AddressService implements DataFetcher<List<Address>> {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> get(DataFetchingEnvironment dfe) {

        Person p = dfe.getSource();
        return addressRepository.findByPersonSet_ids(p.getIds());
    }

}
