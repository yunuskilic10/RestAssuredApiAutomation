package com.otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingTests extends BaseTest {
    @Test
    public void createBookingTest() {

       Response response = createBooking();
        Assert.assertEquals("John", response.jsonPath().getString("booking.firstname"));
        Assert.assertEquals("Doe", response.jsonPath().getString("booking.lastname"));
    }
}
