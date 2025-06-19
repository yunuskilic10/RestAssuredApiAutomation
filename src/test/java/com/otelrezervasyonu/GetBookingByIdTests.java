package com.otelrezervasyonu;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class GetBookingByIdTests extends BaseTest {
    @Test
    public void getBookingById(){
   Response reservation=createBooking();
   int bookingId=reservation.jsonPath().getInt("bookingid");

   Response response = given()
           .when()
           .get("http://restful-booker.herokuapp.com/booking/" + bookingId);

response.then().statusCode(200);
response.prettyPrint();

String firstName = response.jsonPath().getString("firstname");
Assert.assertEquals("John",firstName);
String lastName = response.jsonPath().getString("lastname");
Assert.assertEquals("Doe",lastName);


    }

}
