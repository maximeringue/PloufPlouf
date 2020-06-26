package com.example.demo.rest;

import com.example.demo.repositorie.CoursUtilRepository;
import com.example.demo.transientobj.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CoursControl {

    @Autowired
    CoursUtilRepository coursUtilRepository;


    @GetMapping("{id}")
    public Cours getCours(@PathVariable("id") String id){return this.coursUtilRepository.getCoursWithUtil(id);}
}