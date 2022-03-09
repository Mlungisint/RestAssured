package TestCases1;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC01_Get_Request {

    @Test
    void getweatherDetails_GET(){

        //base uri
        RestAssured.baseURI="https://demoqa.com/BookStore/v1";

        //Request object
        //RequestSpecification httprequest=RestAssured.given();

        //Response object
        /*Response response= httprequest.request(Method.GET,"/Books");*/

        Response response =
                given()
                        .contentType("application/json")
                        .when()
                        .get("/Books")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();
        //http://restapi.demoqa.com/utilities/weather/city
        String responseBdy=response.getBody().asString();
        System.out.println("response Body is :"+ responseBdy);
        //Get status code
        int statusCode=response.getStatusCode();
        int expectedCode=200;
        System.out.println("Current Status code :"+statusCode);
        //Assert the actual code compare to the expected
        Assert.assertEquals(statusCode,expectedCode);
        //Assert if the property ISBN is present of not
        Assert.assertEquals(responseBdy.contains("Git Pocket Guide"),true);

        //get complete json and assert the property using JsonPath class
        JsonPath jsonpath=response.jsonPath();
        //System.out.println(jsonpath.get("book[].title"));
        //Assert.assertEquals(jsonpath.get("title"),"Git Pocket Guide");
    }

    @Test
    void getweatherDetails_POST(){

        //base uri
        RestAssured.baseURI="https://demoqa.com/BookStore/v1";

        //Request object
        //RequestSpecification httprequest=RestAssured.given();

        //Response object
        /*Response response= httprequest.request(Method.GET,"/Books");*/

        Response response =
                given()
                        .contentType("application/json")
                        .when()
                        .get("/Books")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();
        //http://restapi.demoqa.com/utilities/weather/city
        String responseBdy=response.getBody().asString();
        System.out.println("response Body is :"+ responseBdy);
        //Get status code
        int statusCode=response.getStatusCode();
        int expectedCode=200;
        System.out.println("Current Status code :"+statusCode);
        //Assert the actual code compare to the expected
        Assert.assertEquals(statusCode,expectedCode);
        //Assert if the property ISBN is present of not
        Assert.assertEquals(responseBdy.contains("Git Pocket Guide"),true);

        //get complete json and assert the property using JsonPath class
        JsonPath jsonpath=response.jsonPath();
        //System.out.println(jsonpath.get("book[].title"));
        //Assert.assertEquals(jsonpath.get("title"),"Git Pocket Guide");
    }



}
