package steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import java.io.File;

public class BraveNewCoinAPISteps {

    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;

    @Given("^I have a valid API key for the (.*) URI$")
    public void iSetTheRequestParams(String URI) {
        request = given()
                .header("X-RapidAPI-Key", "bc789f3b21msh15f7d3aaaeb4d0fp18cbc6jsnbf3aa716e3fd")
                .header("X-RapidAPI-Host", "bravenewcoin.p.rapidapi.com")
                .contentType(ContentType.JSON)
                .baseUri(URI)
                .log().all();
    }

    @When("^I send a POST request with a valid (.*) payload to the (.*) endpoint$")
    public void sendPOSTRequest(String payload, String endpoint) {
        File requestBody = new File("src/test/resources/payloads/" + payload + ".json");

        response = request.when().body(requestBody).post(endpoint).prettyPeek();
    }

    @Then("^I can validate I received a valid token in the response$")
    public void validateTheToken() {
        response = request
                .when()
                .post("/oauth/token");

        json = response.then().statusCode(200);
    }

    @Given("^I have an invalid API key for the (.*) URI$")
    public void iNotSetTheRequestParams(String URI) {
        request = given()
                .header("X-RapidAPI-Key", "z673k2b458jsh946e1aeb4v981e9p12fo7bjst2bca47l349cf")
                .header("X-RapidAPI-Host", "bravenewcoin.p.rapidapi.com")
                .contentType(ContentType.JSON)
                .baseUri(URI)
                .log().all();
    }

    @Then("^I receive an HTTP code status (.*)$")
    public void validateStatus(int expectedStatusCode) {
        response = request
                .when()
                .post("/oauth/token");

        json = response.then().statusCode(expectedStatusCode);
    }

    @When("^I send a POST request without 'grant_type' in it's body to the (.*) endpoint$")
    public void sendWrongPOSTRequest(String endpoint) {
        File requestBody = new File("src/test/resources/payloads/WrongTokenRequestBody.json");

        response = request.when().body(requestBody).post(endpoint).prettyPeek();
    }
}
