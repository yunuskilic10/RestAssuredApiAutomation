package com.otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class BaseTest {
    protected String bookingObject(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname", "John");
        requestBody.put("lastname", "Doe");
        requestBody.put("totalprice", 111);
        requestBody.put("depositpaid", true);
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");
        requestBody.put("bookingdates", bookingdates);
        requestBody.put("additionalneeds", "Breakfast");
        return requestBody.toString();
    }
    protected Response createBooking(){
        Response response = given()

                .when()
                .contentType(ContentType.JSON)
                .body(bookingObject())
                .post("https://restful-booker.herokuapp.com/booking");
        response.then().statusCode(200);
        response.prettyPrint();
        return response;
    }
}
