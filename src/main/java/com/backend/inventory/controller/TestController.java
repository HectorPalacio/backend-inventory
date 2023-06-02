package com.backend.inventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class TestController {
	
	@GetMapping()
    public String extraBenefit() throws Exception {
        System.out.println(org.hibernate.Version.getVersionString());
        return org.hibernate.Version.getVersionString();
    }
}
