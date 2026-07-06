package org.cognizant;
import org.slf4j.Logger;
import org.slf4j.Logger.*;
import org.slf4j.LoggerFactory;

public class Country {
    private static final Logger log = LoggerFactory.getLogger(Country.class);

    private String name;
    private String code;

    public Country()
    {
        log.debug("Country Constructor");
    }


    public String getName() {
        log.debug("Inside getName");
        return name;
    }

    public void setName(String name) {
        log.debug("Inside setName");
        this.name = name;
    }

    public String getCode() {
        log.debug("Inside getCode");
        return code;
    }

    public void setCode(String code) {
        log.debug("Inside setCode");
        this.code = code;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
