package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        String username = "Azad117";
        int attempts = 3;

        logger.info("username={} , attempts={} ", username, attempts);
        logger.debug("Debug: user={}, attempts={} ", username, attempts);
        logger.error("Error: user={}, attempts={} ", username, attempts);


    }
}