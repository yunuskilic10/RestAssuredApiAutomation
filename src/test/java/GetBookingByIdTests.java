import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class GetBookingByIdTests {
    @Test
    public void getBookingById(){
      Response response =  given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/663");
      //response.then().log().all().statusCode(200);
        response.then().statusCode(200);
        response.prettyPrint();
String firstName = response.jsonPath().getJsonObject("firstname");
Assert.assertEquals("Josh",firstName);
String lastName = response.jsonPath().getJsonObject("lastname");
Assert.assertEquals("Allen",lastName);


    }

}
