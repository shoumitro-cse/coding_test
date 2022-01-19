/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoumitro.coding_test;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author shoumitro
 */
public interface ParentPageRepository extends JpaRepository<Parent, Long> {
  Page<Parent> findAll(Pageable pageable);
  Page<Parent> findBySenderContaining(String sender, Pageable pageable);
}