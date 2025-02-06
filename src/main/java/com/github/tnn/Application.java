package com.github.tnn;

import io.micronaut.context.annotation.Factory;
import io.micronaut.runtime.Micronaut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Factory
public class Application {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        try {
            Micronaut.build(args)
                    .packages("com.github.tnn")
                    .eagerInitSingletons(true)
                    .start();
        } catch (Throwable t) {
            LOG.error("Could not start Micronaut", t);
        }
    }
}