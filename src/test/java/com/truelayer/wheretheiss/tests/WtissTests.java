package com.truelayer.wheretheiss.tests;

import com.truelayer.wheretheiss.api.StatusCode;
import com.truelayer.wheretheiss.api.applicationApi.WTISSApi;
import com.truelayer.wheretheiss.pojo.Wtiss;
import com.truelayer.wheretheiss.pojo.WtissTLE;
import com.truelayer.wheretheiss.utils.DataLoader;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Epic("WTISS v1")
@Feature("WTISS API")
public class WtissTests extends BaseTest {


    @Story("Get Satellite positions")
    @Test(description = "Get Satellite position with default Unit kilometers and one timestamp")
    public void SuccessfullyGetPositionDefaultUnitForAGivenTimeStamp() {
        Response response = WTISSApi.getPosition(DataLoader.getInstance().getCatalogId(), DataLoader.getInstance().get_timestamp());
        System.out.println("response is " + response.getBody().asPrettyString());
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertWtissEqual(response.as(Wtiss[].class));
    }

    @Test(description = "Get Satellite position with Unit as Miles and 2 timestamps")
    public void SuccessfullyGetPositionMileUnitForMaxTimeStamp() {
        Response response = WTISSApi.getPosition(DataLoader.getInstance().getCatalogId(), DataLoader.getInstance().get_timestamp_list(), DataLoader.getInstance().get_unit_miles());
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertWtissEqual(response.as(Wtiss[].class));
    }

    @Story("Negative - Get Satellite positions")
    @Test(description = "Negative scenario to test if the timestamp provided is more than 10")
    public void NotAllowToGetMoreThan10TimeStamp() {
        Response response = WTISSApi.getPosition(DataLoader.getInstance().getCatalogId(), DataLoader.getInstance().get_timestamp_list_error(), DataLoader.getInstance().get_unit_miles());
        assertStatusCode(response.statusCode(), StatusCode.CODE_400);
        assertWtissEqual(response.as(Wtiss[].class));
    }

    @Test(description = "Get TLES data with default format as json")
    public void SuccessfullyGetTLESDefault() {
        Response response = WTISSApi.getTLES(DataLoader.getInstance().getCatalogId());
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertWtissTLEEqual(response.as(WtissTLE.class));
    }

   /* @Test
    public void SuccessfullyGetTLESText() {
        //Wtiss requestBuilder = wtissBuilder();
        Response response = WTISSApi.getTLES(DataLoader.getInstance().getCatalogId(), "text");
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertWtissTLEEqual(response.as(WtissTLE.class));
    }*/



    @Step
    public void assertWtissEqual(Wtiss[] responseWtiss) {
        int count = 0;
        List<Wtiss> resultList = Arrays.stream(responseWtiss).collect(Collectors.toList());
        resultList.forEach(x -> {
                               if (x.getName().equals("iss")) {
                                   System.out.println("success");
                                   assertThat(" name matches ", true);
                               } else {
                                   System.out.println("failed");
                                   assertThat(" name mismatches ", false);

                               }

                           }

        );
        count = resultList.size();
        System.out.println("count is " + count);
    }

    @Step
    public void assertWtissTLEEqual(WtissTLE responseWtiss) {
        int count = 0;
        List<WtissTLE> resultList = Arrays.asList(responseWtiss);
        resultList.forEach(x -> {
                               if (x.getId().equals("25544")) {
                                   System.out.println("success");
                                   assertThat(" id match ", true);
                               } else {
                                   System.out.println("failed");
                                   assertThat("no id match ", false);
                               }

                           }

        );
        count = resultList.size();
        System.out.println("count is " + count);
    }


    @Step
    public void assertStatusCode(int actualStatusCode, StatusCode statusCode) {
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }


}
