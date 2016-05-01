package com.go.euro.test.app;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.go.euro.test.model.City;
import com.go.euro.test.service.GoEuroCityService;
import com.go.euro.test.util.WriterUtils;
import com.google.common.base.Strings;

/**
 * Application class.
 * 
 * @author Piyusht007
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static final String BASE_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";

    /**
     * Main method that takes city name from the command line.
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final String cityName = args[0];

        if (Strings.isNullOrEmpty(cityName)) {
            throw new IllegalArgumentException("City name cannot be null/empty. Please provide a valid city name.");
        }

        final GoEuroCityService cityService = GoEuroCityService.newGoEuroCityService(BASE_URL);
        final List<City> cities = cityService.getCities(cityName);

        if (cities == null || cities.isEmpty()) {
            logger.info("Details not found for city : {}", cityName);
        } else {
            WriterUtils.saveToCSV(cities);
        }
    }
}
