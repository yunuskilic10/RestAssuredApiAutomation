package com.otelrezervasyonu;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetAllBookingsTests {
    @Test
    public void getAllBookingTest() {
        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .log().all()
                .statusCode(200);

    }
}
