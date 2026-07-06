package org.cognizant;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Logger log =  LoggerFactory.getLogger(Main.class);
    public static void displayCountry()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country country = context.getBean("country",Country.class);
        log.debug("Country : {} ",country);
    }
    public static void main(String[] args) {

        displayCountry();
    }
}