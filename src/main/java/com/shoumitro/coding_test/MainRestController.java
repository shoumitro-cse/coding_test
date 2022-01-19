/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoumitro.coding_test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author shoumitro
 */

@RestController
public class MainRestController {
    @Autowired
    private ParentService parentService;
        
    @Autowired
    private ChildService childService;

        
    @GetMapping(value = "/parents")
    public List<Parent> getParent() {
        List list = new ArrayList();
        
        List<Parent> parents = (List<Parent>) parentService.getAllParents();
        for (int counter = 0; counter < parents.size(); counter++) { 
            Parent obj = parents.get(counter);
            Map map = new HashMap();
            map.put("totalPaidAmount", obj.getTotalPaidAmount());
            map.put("totalAmount", obj.getTotalAmount());
            map.put("recever", obj.getReceiver());
            map.put("sender", obj.getSender());
            map.put("id", obj.getId());
            list.add(map);
        }       
        return list;
    }
    
    
    @GetMapping(value = "/childs")
    public List<Parent> getChild() {
        List list = new ArrayList();
        
        List<Child> childs = (List<Child>) childService.getAllChilds();
        for (int counter = 0; counter < childs.size(); counter++) { 
            Child obj = childs.get(counter);
            Map map = new HashMap();
            map.put("paidAmount", obj.getPaidAmount());
            map.put("totalAmount", obj.getParent().getTotalAmount());
            map.put("recever", obj.getParent().getReceiver());
            map.put("sender", obj.getParent().getSender());
            map.put("id", obj.getId());
            list.add(map);
        }       
        return list;
    } 
}
