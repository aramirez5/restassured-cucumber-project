import io.restassured.response.Response
import org.testng.Assert
import org.testng.annotations.Test 

import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*

class Books extends Base {

    @Test(groups = "get")
    void "Get the books list"() {
        Response response = get("/books")

        ArrayList<String> allBooks = response.path("data.title")
        Assert.assertTrue(allBooks.size() > 1, "No books found")
    }

     @Test(groups = "get")
    void "Check the books schema is valid"(){
        get("/books")
        .then()
        .assertThat()
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("booksSchema.json"))
    }

    @Test(groups = "post")
    void "Create and delete a book"(){
        File bookFile = new File(getClass().getResource("/book.json").toURI())
    
        Response createResponse = 
            given()
            .body(bookFile)
            .when()
            .post("/books")

        String responseID = createResponse.jsonPath().getString("post.book_id")

        Assert.assertEquals(createResponse.getStatusCode(), 201)

        Response deleteResponse = 
            given()
            .body("{\n" + "\t\"book_id\": " + responseID + "\n" + "}")
            .when()
            .delete("/books")
        Assert.assertEquals(deleteResponse.getStatusCode(), 200)
        Assert.assertEquals(deleteResponse.jsonPath().getString("message"),"Book successfully deleted")    
    }

    @Test(groups = "delete")
    void "Delete a non existent book"(){
        String nonExistentBookID = "456123"

        Response deleteResponse = 
            given ()
            .body("{\n" + "\t\"book_id\": " + nonExistentBookID + "\n" + "}")
            .when()
            .delete("/books")
        
        Assert.assertEquals(deleteResponse.getStatusCode(), 500)
        Assert.assertEquals(deleteResponse.jsonPath().getString("error"),"Unable to find book id: " + nonExistentBookID)
    }
}