package com.otelrezervasyonu;



import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetAllBookingsTests extends BaseTest {
    @Test
    public void getAllBookingTest() {
        given(specification)
                .when()
                .get("/booking")
                .then()
                .statusCode(200);

    }
}
