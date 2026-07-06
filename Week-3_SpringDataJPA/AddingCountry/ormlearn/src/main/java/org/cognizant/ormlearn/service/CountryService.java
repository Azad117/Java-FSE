package org.cognizant.ormlearn.service;

import jakarta.transaction.Transactional;
import org.cognizant.ormlearn.model.Country;
import org.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repo;

    public CountryService(CountryRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public void addNewCountry(Country country) {
        repo.save(country);
    }

    public Country getCountryById(String code) {
        return repo.findById(code).orElse(null);

    }
}
