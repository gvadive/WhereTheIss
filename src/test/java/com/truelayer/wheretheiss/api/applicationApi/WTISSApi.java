package com.truelayer.wheretheiss.api.applicationApi;

import com.truelayer.wheretheiss.api.RestResource;
import io.restassured.response.Response;

import static com.truelayer.wheretheiss.api.Route.*;


public class WTISSApi {

    public static Response getPosition(String catalogId, String timeStamp) {
        return RestResource.getPosition(BASE_PATH + catalogId + POSITIONS,timeStamp);
    }

    public static Response getPosition(String catalogId, String timeStamp, String unit) {
        return RestResource.getPosition(BASE_PATH + catalogId +POSITIONS,timeStamp,unit);
    }

    public static Response getTLES(String catalogId){
        return RestResource.getTLES(BASE_PATH + catalogId+ TLES);
    }

    public static Response getTLES(String catalogId, String format) {
        return RestResource.getTLES(BASE_PATH + catalogId + TLES,format);
    }




}
