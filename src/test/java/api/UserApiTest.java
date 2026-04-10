package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.EnvReader;


public class UserApiTest {

    @Test
    public void getUsersTest() {

        String apiKey = EnvReader.get("API_KEY");

        Response response = RestAssured
                .given()
                .header("x-api-key", apiKey)
                .when()
                .get("https://reqres.in/api/users?page=2");

        // Print response (for debugging)
        System.out.println(response.asString());

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.asString().contains("Michael"));
    }
}