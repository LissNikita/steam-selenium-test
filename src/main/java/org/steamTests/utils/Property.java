package org.steamTests.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.NoSuchElementException;
import java.util.Properties;

public class Property {

    public static String getPropertyValue(String propertyName) {
        Properties properties = new Properties();

        try (InputStream inputStream = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        if (properties.getProperty(propertyName) != null) {
            return properties.getProperty(propertyName);
        } else {
            throw new NoSuchElementException(propertyName + " is not found");
        }
    }
}