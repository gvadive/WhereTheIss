package com.truelayer.wheretheiss.api;

import io.restassured.response.Response;


import static com.truelayer.wheretheiss.api.SpecBuilder.*;
import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response getPosition(String path, String timeStamp) {
        return given(getRequestSpec()).
                queryParam("timestamps", timeStamp).
                when().get(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response getPosition(String path, String timeStamp, String units) {
        return given(getRequestSpec()).
                queryParam("timestamps", timeStamp).
                queryParam("units", units).
                when().get(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response getTLES(String path) {
        return given(getRequestSpec()).
                when().get(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response getTLES(String path, String format){
        return given(getRequestSpec()).
                param("format",format).
        when().get(path).
        then().spec(getResponseSpec()).
                extract().
                response();
    }




}
