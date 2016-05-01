package com.go.euro.test.model;

import com.google.gson.annotations.SerializedName;

/**
 * Model class that represents city.
 * 
 * @author Piyusht007
 */
public class City {
    private final Long _id;
    private final String key;
    private final String name;
    private final String fullName;
    private final String iata_airport_code;
    private final String type;
    private final String country;
    @SerializedName("geo_position")
    private final GeoPosition geoPosition;
    private final Long locationId;
    private final Boolean inEurope;
    private final String countryCode;
    private final Boolean coreCountry;
    private final Integer distance;

    /**
     * Constructor.
     * 
     * @param _id
     * @param key
     * @param name
     * @param fullName
     * @param iata_airport_code
     * @param type
     * @param country
     * @param geoPosition
     * @param locationId
     * @param inEurope
     * @param countryCode
     * @param coreCountry
     * @param distance
     */
    public City(Long _id, String key, String name, String fullName, String iata_airport_code, String type,
            String country, GeoPosition geoPosition, Long locationId, Boolean inEurope, String countryCode,
            Boolean coreCountry, Integer distance) {
        this._id = _id;
        this.key = key;
        this.name = name;
        this.fullName = fullName;
        this.iata_airport_code = iata_airport_code;
        this.type = type;
        this.country = country;
        this.geoPosition = geoPosition;
        this.locationId = locationId;
        this.inEurope = inEurope;
        this.countryCode = countryCode;
        this.coreCountry = coreCountry;
        this.distance = distance;
    }

    /**
     * @return _id
     */
    public Long get_id() {
        return _id;
    }

    /**
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @return iata_airport_code
     */
    public String getIata_airport_code() {
        return iata_airport_code;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return geoPosition
     */
    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    /**
     * @return locationId
     */
    public Long getLocationId() {
        return locationId;
    }

    /**
     * @return inEurope
     */
    public Boolean getInEurope() {
        return inEurope;
    }

    /**
     * @return countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @return coreCountry
     */
    public Boolean getCoreCountry() {
        return coreCountry;
    }

    /**
     * @return distance
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "City [_id=" + _id + ", key=" + key + ", name=" + name + ", fullName=" + fullName
                + ", iata_airport_code=" + iata_airport_code + ", type=" + type + ", country=" + country
                + ", geoPosition=" + geoPosition + ", locationId=" + locationId + ", inEurope=" + inEurope
                + ", countryCode=" + countryCode + ", coreCountry=" + coreCountry + ", distance=" + distance + "]";
    }
}
