package com.otelrezervasyonu;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class UpdateBookingTests extends BaseTest {
    @Test
    public void updateBookingTest(){


      Response response=given(specification).contentType(ContentType.JSON).header("Cookie","token="+createToken())
              .when()
              .body(bookingObject("John", "Doe", 100))
              .put("/booking/"+createBookingId());
        response.then().statusCode(200);

        Assert.assertEquals("John", response.jsonPath().getString("firstname"));


    }
}
