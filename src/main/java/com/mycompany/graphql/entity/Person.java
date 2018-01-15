/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graphql.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author D.Nazer
 */
@Entity
public class Person implements Serializable {

    @Id
    private Long ids;
    private String first_name;
    private String last_name;
    private String title;

    public Person() {
    }

    public Long getIds() {
        return ids;
    }

    public void setIds(Long ids) {
        this.ids = ids;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
