package com.otelrezervasyonu;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdateBookingTests extends BaseTest {
    @Test
    public void updateBookingTest(){
        String token=createToken();
        Response createBooking=createBooking();
      int bookingId=  createBooking.jsonPath().getInt("bookingid");
      Response response=given().contentType(ContentType.JSON).header("Cookie","token="+token)
              .when()
              .body(bookingObject("John", "Doe", 100))
              .put("https://restful-booker.herokuapp.com/booking/"+bookingId);
        response.then().statusCode(200);
        response.prettyPrint();
        Assert.assertEquals("John", response.jsonPath().getString("firstname"));


    }
}
