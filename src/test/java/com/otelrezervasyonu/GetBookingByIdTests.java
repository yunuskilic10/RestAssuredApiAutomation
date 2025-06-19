package com.otelrezervasyonu;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class GetBookingByIdTests extends BaseTest {
    @Test
    public void getBookingById(){


   Response response = given()
           .when()
           .get("http://restful-booker.herokuapp.com/booking/" + createBookingId());

response.then().statusCode(200);
response.prettyPrint();

String firstName = response.jsonPath().getString("firstname");
Assert.assertEquals("Yunus",firstName);
String lastName = response.jsonPath().getString("lastname");
Assert.assertEquals("Emre",lastName);


    }

}
