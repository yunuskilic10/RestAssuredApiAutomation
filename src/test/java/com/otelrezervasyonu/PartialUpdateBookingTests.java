package com.otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PartialUpdateBookingTests extends BaseTest {
    @Test
    public void partialUpdateBookingTest() {


        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname", "Mehmet");
        requestBody.put("lastname", "Atar");
        Response response = given().contentType(ContentType.JSON).header("Cookie", "token=" + createToken())
                .when()
                .body(requestBody.toString())
                .patch("https://restful-booker.herokuapp.com/booking/" +createBookingId());
        response.then().statusCode(200);
        response.prettyPrint();
        Assert.assertEquals("Mehmet", response.jsonPath().getString("firstname"));
        Assert.assertEquals("Atar", response.jsonPath().getString("lastname"));

    }
}
