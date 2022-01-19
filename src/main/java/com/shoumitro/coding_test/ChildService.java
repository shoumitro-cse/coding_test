/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoumitro.coding_test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shoumitro
 */

@Service
public class ChildService {
    @Autowired
    ChildRepository childRepository;
    
    
    //getting all record by using the method findaAll() of CrudRepository
    public List<Child> getAllParents() {
        List<Child> childs = new ArrayList<Child>();
        childRepository.findAll().forEach(new Consumer<Child>() {
            @Override
            public void accept(Child child) {
                childs.add(child);
            }
        });
        return childs;
    }
    
   
   //getting a specific record by using the method findById() of CrudRepository
    public Child getChildById(int id) {
        return childRepository.findById(id).get();
    }
    
    
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Child child) {
        childRepository.save(child);
    }
    
    
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id) {
        childRepository.deleteById(id);
    }
    
    //updating a record
    public void update(Child child, int id) {
        childRepository.save(child);
    }
    
    // insert record
    public void save(Child child) {
        childRepository.save(child);
    }
}
