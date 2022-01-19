/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoumitro.coding_test;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author shoumitro
 */
public interface ChildRepository extends CrudRepository<Child, Integer> {
    
}
