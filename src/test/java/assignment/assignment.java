package assignment;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;




public class assignment {


    @DisplayName("POST /api/spartan ")
    @Test
    public void test_Maintenance() {


        Map<String, Object> postRequestMap = new HashMap<>();
        postRequestMap.put("sku", "berliner");
        postRequestMap.put("description", "Jelly donut");
        postRequestMap.put("price", "2.99");

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(postRequestMap) //set request json body. map > json
                .when().post("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus");

        response.prettyPrint();

        assertThat(response.statusCode(), equalTo(200));
        assertThat(response.contentType(), equalTo("application/json"));
    }

    @Test
    public void testGet() {
        Map<String, Object> getRequestMap = new HashMap<>();
        getRequestMap.put("sku", "berliner");
        getRequestMap.put("description", "Jelly donut");
        getRequestMap.put("price", "2.99");

        Response response = given().accept(ContentType.JSON)
                .when().get("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus");


        System.out.println("GET request body :");
        response.prettyPrint();
    }

    @Test
    public void testGetUsingID() {

        Map<String, Object> getIDRequestMap = new HashMap<>();
        getIDRequestMap.put("sku", "berliner");
        getIDRequestMap.put("description", "Jelly donut");
        getIDRequestMap.put("price", "2.99");

        Response response1 = given().accept(ContentType.JSON)
                .and().pathParam("id", "U8EPVJE9UJE9KGPE6NM1U6VU77VV4KQNSO5AEMVJF66Q9ASUAAJG")
                .when().get("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus/{id}");


        System.out.println("GET request body :");
        response1.prettyPrint();

    }

    @Test
    public void deleteSpartanById() {
        Map<String, Object> delRequestMap = new HashMap<>();
        delRequestMap.put("sku", "berliner");
        delRequestMap.put("description", "Jelly donut");
        delRequestMap.put("price", "2.99");

        Response delResponse = given().accept(ContentType.JSON)
                .and().pathParam("id", "BVPJN8JIUVI05C53MGU8IDIC7BVV4KQNSO5AEMVJF66Q9ASUAAJG")
                .when().delete("https://1ryu4whyek.execute-api.us-west-2.amazonaws.com/dev/skus/{id}");

        System.out.println("Deleted request body :");
        delResponse.prettyPrint();
    }



}
