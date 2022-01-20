package com.truelayer.wheretheiss.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.truelayer.wheretheiss.api.StatusCode;
import com.truelayer.wheretheiss.api.applicationApi.WTISSApi;
import com.truelayer.wheretheiss.pojo.WtIssPosition;
import com.truelayer.wheretheiss.pojo.WtIssTLE;
import com.truelayer.wheretheiss.pojo.WtIssTLEText;
import com.truelayer.wheretheiss.utils.DataLoader;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Epic("WTISS v1")
@Feature("WTISS API")
public class WtIssPositionTests extends BaseTest {

    ObjectMapper mapper = new ObjectMapper();

    @Story("Get Satellite positions")
    @Test(description = "Get Satellite position with default Unit kilometers and one timestamp")
    public void SuccessfullyGetPositionDefaultUnitForAGivenTimeStamp() throws IOException {
        WtIssPosition[] expectedValue = mapper.readValue(new File("src/test/resources/ResponseBodyWTISSPosition.json"), WtIssPosition[].class);
        Response response = WTISSApi.getPosition(DataLoader.getInstance().getCatalogId(), DataLoader.getInstance().get_timestamp());
        WtIssPosition[] actualValue= response.as(WtIssPosition[].class);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertWtIssEqual(actualValue,expectedValue);
    }

    @Story("Get Satellite positions")
    @Test(description = "Get Satellite position with Unit as Miles and 2 timestamps")
    public void SuccessfullyGetPositionMileUnitForMaxTimeStamp() throws IOException {
        WtIssPosition[] expectedValue = mapper.readValue(new File("src/test/resources/ResponseBodyWTIssPosMiles.json"), WtIssPosition[].class);
        Response response = WTISSApi.getPosition(DataLoader.getInstance().getCatalogId(), DataLoader.getInstance().get_timestamp_list(), DataLoader.getInstance().get_unit_miles());
        WtIssPosition[] actualValue = response.as(WtIssPosition[].class);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertWtIssEqual(actualValue, expectedValue);
    }

    @Story("Negative - Get Satellite positions")
    @Test(description = "Negative scenario to test when the timestamp provided is more than 10")
    public void NotAllowToGetMoreThan10TimeStamp() throws IOException {
        WtIssPosition[] expectedValue = mapper.readValue(new File("src/test/resources/ResponseBodyWTIssMaxTimeStamp.json"), WtIssPosition[].class);
        Response response = WTISSApi.getPosition(DataLoader.getInstance().getCatalogId(), DataLoader.getInstance().get_timestamp_moreThan_10(), DataLoader.getInstance().get_unit_miles());
        WtIssPosition[] actualValue = response.as(WtIssPosition[].class);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertWtIssEqual(actualValue, expectedValue);
    }

    @Story("Negative - Get Satellite positions")
    @Test(description = "Negative scenario to test when the timestamp provided is more than 10 with extra coma-seperated space")
    public void NotAllowToGetMoreThan10TimeStampWithSpace() throws IOException {
        WtIssPosition[] expectedValue = mapper.readValue(new File("src/test/resources/ResponseBodyWTIssMaxTimeStampWihSpace.json"), WtIssPosition[].class);
        Response response = WTISSApi.getPosition(DataLoader.getInstance().getCatalogId(), DataLoader.getInstance().get_timestamp_moreThan_10WithSpace(), DataLoader.getInstance().get_unit_miles());
        WtIssPosition[] actualValue = response.as(WtIssPosition[].class);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertWtIssEqual(actualValue, expectedValue);
    }

    @Story("Get Satellite TLEs")
    @Test(description = "Get TLES data with default format as json")
    public void SuccessfullyGetTLESDefault() throws IOException {
        WtIssTLE expectedValue = mapper.readValue(new File("src/test/resources/ResponseBodyTLE.json"), WtIssTLE.class);
        Response response = WTISSApi.getTLES(DataLoader.getInstance().getCatalogId());
        WtIssTLE actualValue = response.as(WtIssTLE.class);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertWtIssTLEEqual(actualValue,expectedValue);
    }

    /*
    @Story("Get Satellite TLEs")
    @Test(description = "Get TLES data with format as text")
    public void SuccessfullyGetTLESText() throws IOException {
        WtIssTLEText expectedValue = mapper.readValue(new File("src/test/resources/ResponseBodyTLETextFormat.txt"), WtIssTLEText.class);
        Response response = WTISSApi.getTLES(DataLoader.getInstance().getCatalogId(), "text");
        WtIssTLEText actualValue = response.as(WtIssTLEText.class);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertWtIssTLETextEqual(actualValue, expectedValue);
    }*/


    @Step
    public void assertWtIssEqual(WtIssPosition[] actualValue, WtIssPosition[] expectedValue) throws JsonProcessingException {
        assertThat(mapper.writeValueAsString(actualValue), equalTo(mapper.writeValueAsString(expectedValue)));
    }

    @Step
    public void assertWtIssTLEEqual(WtIssTLE actualValue, WtIssTLE expectedValue) throws JsonProcessingException {
        assertThat(mapper.writeValueAsString(actualValue), equalTo(mapper.writeValueAsString(expectedValue)));
    }

    @Step
    public void assertWtIssTLETextEqual(WtIssTLEText actualValue, WtIssTLEText expectedValue) throws JsonProcessingException {
        assertThat(mapper.writeValueAsString(actualValue), equalTo(mapper.writeValueAsString(expectedValue)));
    }


    @Step
    public void assertStatusCode(int actualStatusCode, StatusCode statusCode) {
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }


}
