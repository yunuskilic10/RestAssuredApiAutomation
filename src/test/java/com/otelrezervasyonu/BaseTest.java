package com.otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class BaseTest {
    protected String bookingObject(String firstName, String lastName, int  totalprice) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname", firstName);
        requestBody.put("lastname", lastName);
        requestBody.put("totalprice", totalprice);
        requestBody.put("depositpaid", true);
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");
        requestBody.put("bookingdates", bookingdates);
        requestBody.put("additionalneeds", "Breakfast");
        return requestBody.toString();
    }

    protected Response createBooking() {
        Response response = given()

                .when()
                .contentType(ContentType.JSON)
                .body(bookingObject("Yunus", "Emre", 100))
                .post("https://restful-booker.herokuapp.com/booking");
        response.then().statusCode(200);
        response.prettyPrint();
        return response;
    }
     protected int createBookingId() {
        Response response = createBooking();
        int bookingId = response.jsonPath().getInt("bookingid");
        return bookingId;
    }
    protected String createToken() {
        JSONObject newToken = new JSONObject();
        newToken.put("username", "admin");
        newToken.put("password", "password123");
        Response response = given().contentType(ContentType.JSON).when().
                body(newToken.toString()).
                post("https://restful-booker.herokuapp.com/auth");
        response.then().statusCode(200);
        response.prettyPrint();
         String token = response.jsonPath().getString("token");
         return token;

    }
}
