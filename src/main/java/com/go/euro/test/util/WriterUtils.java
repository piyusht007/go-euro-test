package com.go.euro.test.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.go.euro.test.model.City;
import com.opencsv.CSVWriter;

/**
 * Utility class for saving the results.
 * 
 * @author Piyusht007
 */
public class WriterUtils {
    private static final Logger logger = LoggerFactory.getLogger(WriterUtils.class);

    /**
     * To write the result in CSV file.
     * 
     * @param cities
     *            - List of {@link City} objects to written to CSV file.
     */
    public static void saveToCSV(final List<City> cities) {
        try (final CSVWriter writer = new CSVWriter(new FileWriter("cities.csv"))) {
            if (cities != null && !cities.isEmpty()) {
                for (final City city : cities) {
                    writer.writeNext(new String[] { String.valueOf(city.get_id()), //
                            city.getName(), //
                            city.getType(), //
                            String.valueOf(city.getGeoPosition().getLatitude()), //
                            String.valueOf(city.getGeoPosition().getLongitude()) });
                }
            }
        } catch (final IOException e) {
            logger.error("Exception occurred while writing cities details to file. Exception desc : {}",
                    e.getMessage());
        }
    }
}
