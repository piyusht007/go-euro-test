package com.go.euro.test.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.go.euro.test.model.City;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Service class that make calls to GoEuro city service.
 * 
 * @author Piyusht007
 */
public class GoEuroCityService {
    private static final Logger logger = LoggerFactory.getLogger(GoEuroCityService.class);
    // As Gson object is resource intensive sharing it across the service
    // objects.
    private static final Gson GSON = new GsonBuilder().create();
    // This can also be shared as the response structure of the service is static. 
    private static final Type structure = new TypeToken<List<City>>() {
    }.getType();

    private final String baseURL;

    /**
     * Constructor.
     * 
     * @param baseURL
     *            - The base URL of the service.
     */
    private GoEuroCityService(final String baseURL) {
        this.baseURL = baseURL;
    }

    /**
     * Static factory method to create instances of this service.
     * 
     * @param baseURL
     *            - The URL of the service.
     * @return {@link GoEuroCityService}
     */
    public static GoEuroCityService newGoEuroCityService(final String baseURL) {
        return new GoEuroCityService(baseURL);
    }

    /**
     * To get the cities which contains passed cityName.
     * 
     * @param cityName
     *            - The name of the city.
     * @return List<Cities>
     */
    public List<City> getCities(final String cityName) {
        List<City> cities = new ArrayList<>();
        HttpURLConnection con = null;

        try {
            final URL url = new URL(baseURL + cityName);
            con = (HttpURLConnection) url.openConnection();
            final int responseCode = con.getResponseCode();

            logger.debug("Sending 'GET' request to URL : {}", url);
            logger.debug("Response Code : {}", responseCode);
        } catch (final MalformedURLException e) {
            logger.error("URL was malformed : {}", e.getMessage());
        } catch (final IOException e) {
            logger.error("Error while connecting to the GoEuro city service : {}", baseURL, " for city {}", cityName);
        }

        try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            final StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            if (response != null) {
                cities = GSON.fromJson(response.toString(), structure);
            }
        } catch (final IOException e) {
            logger.error("Error while reading the response of GoEuro city service : {}", baseURL, " for city {}",
                    cityName);
        }

        return cities;
    }
}
