package org.cognizant.springjpa.controller;

import org.cognizant.springjpa.model.Country;
import org.cognizant.springjpa.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("countries")
    public List<Country> findAllCountry() {
        return countryService.findAll();
    }

    @GetMapping("/{code}")
    public Country findCountryById(@PathVariable String code) {
        return countryService.findByCode(code);
    }

    @PostMapping("/add")
    public String addCountry(@RequestBody Country country) {
        return countryService.addnew(country);
    }

    @PutMapping("/update")
    public String updateCountry(@RequestBody Country country) {
        return countryService.updatecountry(country);
    }

    @DeleteMapping("/delete")
    public String deleteCountry(String code) {
        return countryService.delete(code);
    }


}
