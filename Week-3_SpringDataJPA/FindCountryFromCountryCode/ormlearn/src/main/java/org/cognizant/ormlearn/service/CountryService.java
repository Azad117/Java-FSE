package org.cognizant.ormlearn.service;

import jakarta.transaction.Transactional;
import org.cognizant.ormlearn.model.Country;
import org.cognizant.ormlearn.repository.CountryRepository;
import org.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional
    public Country findByCountryCode(String code) throws CountryNotFoundException
    {
        Optional<Country> result = countryRepository.findById(code);

        if(!result.isPresent())
            throw new CountryNotFoundException();

        return result.get();
    }

}
