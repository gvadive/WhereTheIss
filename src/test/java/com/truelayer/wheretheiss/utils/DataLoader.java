package com.truelayer.wheretheiss.utils;

import java.util.Properties;

public class DataLoader {
    private final Properties properties;
    private static DataLoader dataLoader;

    private DataLoader(){
        properties = PropertyUtils.propertyLoader("src/test/resources/data.properties");
    }

    public static DataLoader getInstance(){
        if(dataLoader == null){
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    public String getCatalogId(){
        String prop = properties.getProperty("getCatalogId");
        if(prop != null) return prop;
        else throw new RuntimeException("property getCatalogId is not specified in the data.properties file");
    }

    public String get_timestamp() {
        String prop = properties.getProperty("get_timestamp");
        if (prop != null) return prop;
        else throw new RuntimeException("property get_timestamp is not specified in the data.properties file");
    }

    public String get_timestamp_list() {
        String prop = properties.getProperty("get_timestamp_list");
        if (prop != null) return prop;
        else throw new RuntimeException("property get_timestamp_list is not specified in the data.properties file");
    }

    public String get_unit_miles() {
        String prop = properties.getProperty("get_unit_miles");
        if (prop != null) return prop;
        else throw new RuntimeException("property get_unit_miles is not specified in the data.properties file");
    }

    public String get_unit_km() {
        String prop = properties.getProperty("get_unit_km");
        if (prop != null) return prop;
        else throw new RuntimeException("property get_unit_km is not specified in the data.properties file");
    }

    public String get_timestamp_list_error() {
        String prop = properties.getProperty("get_timestamp_list_error");
        if (prop != null) return prop;
        else throw new RuntimeException("property get_timestamp_list_error is not specified in the data.properties file");
    }

    public String get_timestamp_moreThan_10() {
        String prop = properties.getProperty("get_timestamp_moreThan_10");
        if (prop != null) return prop;
        else
            throw new RuntimeException("property get_timestamp_moreThan_10 is not specified in the data.properties file");
    }

    public String get_timestamp_moreThan_10WithSpace() {
        String prop = properties.getProperty("get_timestamp_moreThan_10WithSpace");
        if (prop != null) return prop;
        else
            throw new RuntimeException("property get_timestamp_moreThan_10WithSpace is not specified in the data.properties file");
    }



}
