package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger =
            LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.trace("This is TRACE Message");

        logger.debug("This is DEBUG Message");

        logger.info("This is INFO Message");

        logger.warn("This is WARN Message");

        logger.error("This is ERROR Message");

    }

}