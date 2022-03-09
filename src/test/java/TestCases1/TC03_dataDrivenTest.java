package TestCases1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC03_dataDrivenTest {




    @Test
    void AddBook_POST() {
        getEmpData();


        //base uri
        RestAssured.baseURI = "http://216.10.245.166";

        //Request object
        //RequestSpecification httprequest=RestAssured.given();

        //Response object
        /*Response response= httprequest.request(Method.GET,"/Books");*/

        //CREATE DATA TO POST WITH REQUEST THROUGH JSONBODY OBJECT METHOD
        JSONObject requestParams = new JSONObject();

        requestParams.put("name", "mluto");
        requestParams.put("isbn", "146");
        requestParams.put("aisle", "002");
        requestParams.put("author", "Mlungisi Books");

        Response response =
                given()
                        .contentType("application/json")
                        .body(requestParams.toJSONString())
                        .when()
                        .post("/Library/Addbook.php")
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();
        //http://restapi.demoqa.com/utilities/weather/city
        String responseBdy = response.getBody().asString();
        System.out.println("response Body is :" + responseBdy);
        //Get status code
        int statusCode = response.getStatusCode();
        int expectedCode = 200;
        int expectedID = 146002;
        System.out.println("Current Status code :" + statusCode);
        //Assert the actual code compare to the expected
        Assert.assertEquals(statusCode, expectedCode);
        //Assert if the property ISBN is present of not
        Assert.assertEquals(responseBdy.contains("successfully added"), true);

        //get complete json and assert the property using JsonPath class
        JsonPath jsonpath = response.jsonPath();
        System.out.println(jsonpath.get("ID"));
        Assert.assertEquals(jsonpath.get("ID"), expectedID);

        requestParams.put("name", "mluto");
        requestParams.put("isbn", "146");
        requestParams.put("aisle", "002");
        requestParams.put("author", "Mlungisi Books");



    }

    @DataProvider(name="dateprovider")
    Object[][] getEmpData()
    {
        String empdata[][] = {{"mlunto","146","002","mlungisi Books"}, {"mlunto","146","003","mlungisi Books"}, {"mlunto","146","004","mlungisi Books"}};
        return (empdata);
    }



}
