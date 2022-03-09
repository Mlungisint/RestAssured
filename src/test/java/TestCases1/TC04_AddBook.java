package TestCases1;

import com.fasterxml.jackson.core.JsonProcessingException;
import dataProvider.Addbook;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC04_AddBook {

    Addbook Addbook=new Addbook();
    @Test
    public void Add_Book() throws JsonProcessingException {

        RestAssured.baseURI = "http://216.10.245.166";
        dataProvider.Addbook data = Addbook.AddBookdata("Mluto22",85499,"M85499","Mluto Tester");




        Response response =
                given()
                        .contentType("application/json")
                        .body(data).log().all()
                        .when()
                        .post("/Library/Addbook.php")
                        .then()
                        .assertThat()
                        .statusCode(200).log().all()
                        .extract().response();

        String responseBdy=response.getBody().asString();
        System.out.println("Response Body : "+responseBdy);
        int statusCode=response.getStatusCode();
        int expectedCode=200;
        System.out.println("Current Status code :"+statusCode);
        Assert.assertEquals(expectedCode,statusCode);

    }



}
