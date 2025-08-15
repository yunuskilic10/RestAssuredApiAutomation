package com.otelrezervasyonu;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;

public class CreateBookingTests extends BaseTest {
    @Test
    public void createBookingTest() {

       Response response = createBooking();
        Assert.assertEquals("Yunuss", response.jsonPath().getString("booking.firstname"));
        Assert.assertEquals("Emress", response.jsonPath().getString("booking.lastname"));
    }
}
