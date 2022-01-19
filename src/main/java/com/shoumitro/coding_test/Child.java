/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoumitro.coding_test;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

/**
 *
 * @author shoumitro
 */

@Entity
public class Child {
    @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; 
    private Float paidAmount;
    
    @ManyToOne(targetEntity = Parent.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "parentId",foreignKey = @ForeignKey(name = "fk_child"))
    private Parent parent;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Float paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    
}
