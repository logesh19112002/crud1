package com.example.first.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.first.model.First;
import com.example.first.repository.FirstRepository;

@RestController
@RequestMapping("/api")
public class FirstController {
    @Autowired
    FirstRepository firstRepository;

    @GetMapping("/show_all")
    
    public List<First> getAllDetails(){
        return (List<First>) firstRepository.findAll();
    }

    
    @DeleteMapping("/delete_user")

    public ResponseEntity<HttpStatus> deleteAllUser() {
        firstRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/create_user")

    public ResponseEntity<First> createuser(@RequestBody First first) {
        First first2 = firstRepository
                .save(new First(first.getId(), first.getFirstname(), first.getLastname(), first.getPassword()));

        return new ResponseEntity<First>(first2, HttpStatus.OK);
    }
    
    @PutMapping("/insert/{id}")

    public ResponseEntity<First> updateUser(@PathVariable("id") Long id, @RequestBody First first) {

        Optional<First> first2 = firstRepository.findById(id);

        if (first2.isPresent()) {
            First first3 = first2.get();
            first3.setFirstname(first.getFirstname());
            first3.setLastname(first.getLastname());
            first3.setPassword(first.getPassword());
            return new ResponseEntity<First>(firstRepository.save(first3), HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
