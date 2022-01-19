/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoumitro.coding_test;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author shoumitro
 */


@Entity
public class Parent {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String sender;
    private String receiver;
    private Float totalAmount;
    
    @OneToMany(targetEntity = Child.class, cascade = { CascadeType.ALL })  
    @Column(nullable = true)
    private List<Child> childList; 


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public Float getTotalPaidAmount() {
         
        Float totalPaidAmount = 0.0f;
        for (int counter = 0; counter < this.childList.size(); counter++) { 
            totalPaidAmount += this.childList.get(counter).getPaidAmount();
        }
        return totalPaidAmount;
    }
}
