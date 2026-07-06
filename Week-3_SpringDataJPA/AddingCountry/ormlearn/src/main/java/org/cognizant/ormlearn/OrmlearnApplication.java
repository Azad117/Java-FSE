package org.cognizant.ormlearn;

import org.cognizant.ormlearn.model.Country;
import org.cognizant.ormlearn.repository.CountryRepository;
import org.cognizant.ormlearn.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmlearnApplication {

    public static void testAddCountry(ApplicationContext context) {

        CountryService service = context.getBean(CountryService.class);

        Country country = new Country("XY","XYZ Country");
        service.addNewCountry(country);

        System.out.println(country);
    }

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(OrmlearnApplication.class, args);
        testAddCountry(context);
    }

}
