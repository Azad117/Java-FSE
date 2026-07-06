package org.cognizant.ormlearn;

import org.cognizant.ormlearn.model.Country;
import org.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmlearnApplication {

    private static final Logger logger = LoggerFactory.getLogger(OrmlearnApplication.class);

    private static CountryService service;

    public static void getAllCountriesTest()
    {
            logger.info("start");

            Country country = service.findByCountryCode("IN");
            logger.debug("Country : {} ", country);
            logger.info("end");
    }


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmlearnApplication.class, args);
        service = (CountryService) context.getBean("countryService");

        getAllCountriesTest();


    }

}
