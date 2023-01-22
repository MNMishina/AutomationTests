package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import oauth.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SpecBuilderTest {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://www.rahulshettyacademy.com/";

        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setAddress("29, side layout, cohen");
        p.setLanguage("French-In");
        p.setPhone_number("(+91)9838933937");
        p.setName("Frontline house");

        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        p.setTypes(myList);
        Location l = new Location();
        l.setLat(-38.384524);
        l.setLng(33.245876);
        p.setLocation(l);

        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://www.rahulshettyacademy.com/").addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON).build();

        ResponseSpecification respspec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        RequestSpecification res = given().spec(req).body(p);

        Response response = res.when()
                .post("/maps/api/place/add/json")
                .then().spec(respspec).extract().response();

        String responseString = response.asString();
        System.out.println(responseString);

    }

    public static class SerializeTest {

        public static void main(String[] args) {

            RestAssured.baseURI = "https://www.rahulshettyacademy.com/";

            AddPlace p = new AddPlace();
            p.setAccuracy(50);
            p.setAddress("29, side layout, cohen");
            p.setLanguage("French-In");
            p.setPhone_number("(+91)9838933937");
            p.setName("Frontline house");

            List<String> myList = new ArrayList<String>();
            myList.add("shoe park");
            myList.add("shop");

            p.setTypes(myList);
            Location l = new Location();
            l.setLat(-38.384524);
            l.setLng(33.245876);
            p.setLocation(l);

            Response res = given().log().all().queryParam("key", "qaclick123")
                    .body(p)
                    .when()
                    .post("/maps/api/place/add/json")
                    .then().log().all().assertThat().statusCode(200)
                    .extract().response();

            String responseString = res.asString();
            System.out.println(responseString);

        }
    }
}
