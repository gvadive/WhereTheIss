package com.truelayer.wheretheiss.utils;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class JsonSchemaValidators {

    @Test
    public void validateJSonSchema(){

    given().
            baseUri("https://api.wheretheiss.at").
            log().all().
    when().
            get("/v1/satellites/25544/tles").
    then().
           log().all().
           assertThat().
           statusCode(200).
           body(matchesJsonSchemaInClasspath("ResponseBodyTLESchemaValidate.json"));

    }



}
