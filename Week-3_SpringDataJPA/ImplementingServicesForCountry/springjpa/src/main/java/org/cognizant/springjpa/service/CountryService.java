package org.cognizant.springjpa.service;


import org.cognizant.springjpa.model.Country;
import org.cognizant.springjpa.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country findByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    public String addnew(Country country) {
         countryRepository.save(country);
         return "Country added successfully";
    }
    public String updatecountry(Country country) {
        countryRepository.save(country);
        return "Country updated successfully";
    }

    public String delete(String code) {
        countryRepository.deleteById(code);
        return "Country Deleted";
    }

}
