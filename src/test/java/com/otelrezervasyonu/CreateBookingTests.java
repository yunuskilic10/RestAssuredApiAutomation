package com.otelrezervasyonu;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class CreateBookingTests extends BaseTest {
    @Test
    public void createBookingTest() {

       Response response = createBooking();
        Assert.assertEquals("Yunuss", response.jsonPath().getString("booking.firstname"));
        Assert.assertEquals("Emre", response.jsonPath().getString("booking.lastname"));
    }
}
