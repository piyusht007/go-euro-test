package com.go.euro.test.model;

/**
 * Model that represents geo location of the city.
 * 
 * @author Piyusht007
 */
public class GeoPosition {
    private final Double latitude;
    private final Double longitude;

    /**
     * Constructor.
     * 
     * @param latitude
     * @param longitude
     */
    public GeoPosition(final Double latitude, final Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * @return - The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @return - The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "GeoPosition [latitude=" + latitude + ", longitude=" + longitude + "]";
    }
}