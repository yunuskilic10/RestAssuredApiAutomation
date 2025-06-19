import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingTests {
    @Test
    public void createBookingTest() {
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
        Response response = given()

                .when()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post("https://restful-booker.herokuapp.com/booking");
        response.then().statusCode(200);
        response.prettyPrint();
        Assert.assertEquals("John", response.jsonPath().getString("booking.firstname"));
        Assert.assertEquals("Doe", response.jsonPath().getString("booking.lastname"));
    }
}
