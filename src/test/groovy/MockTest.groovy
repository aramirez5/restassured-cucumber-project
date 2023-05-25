// import com.github.fge.jsonschema.SchemaVersion
// import com.github.fge.jsonschema.cfg.ValidationConfiguration
// import com.github.fge.jsonschema.main.JsonSchemaFactory
// import com.github.tomakehurst.wiremock.WireMockServer
// import io.restassured.RestAssured
// import org.junit.AfterClass
// import org.junit.BeforeClass
// import org.junit.Test

// import static com.github.tomakehurst.wiremock.client.WireMock.*
// import static io.restassured.RestAssured.*
// import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath
// import static io.restassured.module.jsv.JsonSchemaValidator.settings
// import static org.hamcrest.Matchers.equalTo
// import static org.hamcrest.Matchers.hasItems

// class MockTest {

//     private static WireMockServer wireMockServer

//     private static final String EVENTS_PATH = "/events?id=390"
//     private static final String APPLICATION_JSON = "application/json"
//     private static final String GAME_ODDS = getEventJson()

//     @BeforeClass
//     public void before() throws Exception {

//         System.out.println("Setting up!")
        
//         final int port = Util.getAvailablePort()
        
//         wireMockServer = new WireMockServer(port)
//         wireMockServer.start()
        
//         Restassured.port = port
//         configureFor("localhost", port)
//         stubFor(get(urlEqualTo(EVENTS_PATH)).willReturn(
//             aResponse().withStatus(200)
//                 .withHeader("Content-Type", APPLICATION_JSON)
//                 .withBody(GAME_ODDS)))
//     }

//     @Test
//     public void givenUrl_whenCheckingFloatValuePasses_thenCorrect(){
//         get("/events?id=390").then().assertThat()
//             .body("odd.ck", equalTo(12.2))
//     }

//     @Test
//     public void givenUrl_whenSuccessOnGetResponseAndJsonHasRequiredKV_thenCorrect(){
//         get("/events?id=390").then().statusCode(200).assertThat()
//             .body("id", equalTo(390))
//     }

//     @Test
//     public void givenUrl_whenJsonResponseHasArrayWithGivenValuesUnderKey_thenCorrect(){
//         get("/events?id=390").then().assertThat()
//             .body("odds.price", hasItems("1.30","5.25","2.70","1.20"))
//     }

//     @Test
//     public void givenUrl_whenJsonResponseConformsToSchema_thenCorrect(){
//         get("/events?id=390").then().assertThat()
//             .body(matchesJsonSchemaInClasspath(event.json))
//     }

//     @Test
//     public void givenUrl_whenValidatesResponseWithInstanceSettings_thenCorrect(){
//         JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory
//             .newBuilder()
//             .setValidationConfiguration(
//                 ValidationConfiguration.newBuilder()
//                     .setDefaultVersion(SchemaVersion.DRAFTV4)
//                     .freeze()).freeze()
        
//         get("/events?id=390")
//             .then()
//             .assertThat()
//             .body(matchesJsonSchemaInClasspath(event.json)
//             .using(jsonSchemaFactory))
//     }

//     @Test
//     public void givenUrl_whenValidateResponseWithStaticSettings_thenCorrect(){
//         get("/events?id=390")
//             .then()
//             .assertThat()
//             .body(matchesJsonSchemaInClasspath(event.json)
//             .using(settings().with().checkedValidation(false)))
//     }

//     @AfterClass
//     public static void after() throws Exception {
//         System.out.println("Running: tearDown");
//         wireMockServer.stop();
//     }
 
        //! Hay un problema con esta función al lanzar los tests
//     private static String getEventJson() {
//         return Util.inputStreamToString(RestAssuredIntegrationTest.class
//           .getResourceAsStream("/event.json"));
//     }
// }