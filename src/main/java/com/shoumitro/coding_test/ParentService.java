/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoumitro.coding_test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import static javafx.scene.input.KeyCode.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shoumitro
 */

@Service
public class ParentService {
    
    @Autowired
    ParentRepository parentRepository;
    
    
    //getting all record by using the method findaAll() of CrudRepository
    public List<Parent> getAllParents() {
        List<Parent> parents = new ArrayList<Parent>();
        parentRepository.findAll().forEach(new Consumer<Parent>() {
            @Override
            public void accept(Parent parent) {
                parents.add(parent);
            }
        });
        return parents;
    }
    
   
   //getting a specific record by using the method findById() of CrudRepository
    public Parent getParentById(int id) {
        return parentRepository.findById(id).get();
    }
    
    
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Parent parent) {
        parentRepository.save(parent);
    }
    
    
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id) {
        parentRepository.deleteById(id);
    }
    
    
    // insert record
    public void save(Parent parent) {
        parentRepository.save(parent);
    }
    
    // updating a record
    public void update(Parent parent, int id) {
        parentRepository.save(parent);
    }
    
    
    public Iterable<Parent> findAll() {
        return parentRepository.findAll();
    }
    
}
