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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author shoumitro
 */
@RestController
public class MainRestController {

    @Autowired
    private ChildService childService;

    @Autowired
    ParentPageRepository parentPageRepository;

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

    @GetMapping("/parents")
    public ResponseEntity<Map<String, Object>> getAllTutorials(
            @RequestParam(required = false) String sender,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {

        try {
            List<Parent> parents = new ArrayList<Parent>();
            Pageable paging = (Pageable) PageRequest.of(page, size);

            Page<Parent> pageTuts;
            if (sender == null) {
                pageTuts = parentPageRepository.findAll(paging);
            } else {
                pageTuts = parentPageRepository.findBySenderContaining(sender, paging);
            }

            parents = pageTuts.getContent();

            List list = new ArrayList();

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

            Map<String, Object> response = new HashMap<>();
            response.put("parents", list);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
