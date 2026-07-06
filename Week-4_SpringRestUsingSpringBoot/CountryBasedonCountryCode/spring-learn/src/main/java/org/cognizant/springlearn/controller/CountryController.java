package org.cognizant.springlearn.controller;

import org.cognizant.springlearn.model.Country;
import org.cognizant.springlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries/{id}")
    public Country getCountry(@PathVariable String id) {
        return countryService.getCountry(id);
    }

}
