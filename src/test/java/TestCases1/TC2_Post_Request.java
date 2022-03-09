package TestCases1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC2_Post_Request {

    @Test
    void getweatherDetails_POST() {

        //base uri
        RestAssured.baseURI = "http://216.10.245.166";

        //Request object
        //RequestSpecification httprequest=RestAssured.given();

        //Response object
        /*Response response= httprequest.request(Method.GET,"/Books");*/

        Response response =
                given()
                        .contentType("application/json")
                        .when()
                        .get("/Library/Addbook.php")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();
    }

}
