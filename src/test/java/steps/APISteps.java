package steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class APISteps {

    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json; 

    @Given("^I send a GET request to the (.+) URI$")
    public void sendRequest(String URI){
        request = given()
            .baseUri(URI)
            .contentType(ContentType.JSON);
    }

    @Then("^I get a (.*) status code$")
    public void validateListOfUsers(int expectedStatusCode) {
        response = request
            .when()
            .get("/users/aramirez5/repos");

        json = response.then().statusCode(expectedStatusCode);
    }

    @Then("^I validate there are (.*) items on the (.*) endpoint$")
    public void validateSize(int expectedSize, String endpoint) {
        response = request
            .when()
            .get(endpoint);

        List<String> jsonResponse = response.jsonPath().getList("$");    
        int actualSize = jsonResponse.size();

        assertEquals(expectedSize, actualSize);
    }

    @Then("^I validate there is a value: (.*) in the response at (.*) endpoint$")
    public void validateValue(String expectedValue, String endpoint) {
        response = request
            .when()
            .get(endpoint);

        List<String> jsonResponse = response.jsonPath().getList("username"); 

        assertTrue("The expected value " +expectedValue+ " is not in the list", jsonResponse.contains(expectedValue));
    }

    @Then("^I validate the nested value: (.*) in the response at (.*) endpoint$")
    public void validateNestedValue(String expectedStreet, String endpoint) {
        response = request
            .when()
            .get(endpoint);

        String jsonResponse = response.jsonPath().getString("address.street");  

        assertTrue("The street " +expectedStreet+ " is not in the list", jsonResponse.contains(expectedStreet));
    }
}
