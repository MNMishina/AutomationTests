package core;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GraphQLScript {

    public static void main(String[] args) {

    // Query don't work
        int characterId = 14;
        String response = given().log().all().header("Content-Type", "application/json")
                .body("{\"query\":\"query($characterId : Int!, $episodeId :Int!} and etc...}")
                .when().post("https://rahulshettyacademy.com/gq/graphql")
                .then().extract().response().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String characterName = js.getString("data.character.name");
        Assert.assertEquals(characterName, "Robin");
    }
}
