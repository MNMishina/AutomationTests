package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pojo.LoginRequest;
import pojo.LoginResponse;
import pojo.OrderDetail;
import pojo.Orders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ECommerceAPITest {

    public static void main(String[] args) {

        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://www.rahulshettyacademy.com/")
                .setContentType(ContentType.JSON).build();

        //  Login
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserEmail("bestfar@mail.ru");
        loginRequest.setUserPassword("Hello123@");

        // SSL relaxedHTTPSValidation() - метод, который доверяет веб-приложению, SSL certifications
        RequestSpecification reqLogin = given().relaxedHTTPSValidation().log().all().spec(req).body(loginRequest);
        LoginResponse loginResponse = reqLogin.when().post("/api/ecom/auth/login").then().log().all()
                .extract().response().as(LoginResponse.class);

        System.out.println(loginResponse.getToken());
        String token = loginResponse.getToken();
        System.out.println(loginResponse.getUserId());
        String userId = loginResponse.getUserId();

        // Add Product
        RequestSpecification addProductReq = new RequestSpecBuilder().setBaseUri("https://www.rahulshettyacademy.com/")
                .addHeader("Authorization", token).build();

        RequestSpecification reqAddProduct = given().log().all().spec(addProductReq).param("productName", "Laptop")
                .param("productAddedBy", userId).param("productCategory", "fashion")
                .param("productSubCategory", "shirts").param("productPrice", "11500")
                .param("productDescription", "Lenova").param("productFor", "men")
                .multiPart("productImage", new File("C://Users//exist//Pictures//1211.jpg"));

        String addProductResponse = reqAddProduct.when().post("/api/ecom/product/add-product").then().log().all()
                .extract().response().asString();

        JsonPath js = new JsonPath(addProductResponse);
        String productId = js.get("productId");

        //  Create Order
        RequestSpecification createOrderBaseReq = new RequestSpecBuilder().setBaseUri("https://www.rahulshettyacademy.com/")
                .addHeader("Authorization", token).setContentType(ContentType.JSON).build();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setCountry("Australia");
        orderDetail.setProductOrderedId(productId);

        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        orderDetailList.add(orderDetail);

        Orders orders = new Orders();
        orders.setOrders(orderDetailList);

        RequestSpecification createOrderReq = given().log().all().spec(createOrderBaseReq).body(orders);
        String responseCreateOrder = createOrderReq.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();

        System.out.println(responseCreateOrder);

        //  Delete Product
        RequestSpecification deleteProductBaseReq = new RequestSpecBuilder().setBaseUri("https://www.rahulshettyacademy.com/")
                .addHeader("Authorization", token).setContentType(ContentType.JSON).build();

        RequestSpecification deleteProdReq = given().log().all().spec(deleteProductBaseReq).pathParam("productId", productId);
        String deleteProductResponse = deleteProdReq.when().delete("/api/ecom/product/delete-product/{productId}").then().log().all()
                .extract().response().asString();

        JsonPath js1 = new JsonPath(deleteProductResponse);
        Assert.assertEquals("Product Deleted Successfully", js1.get("message"));

        // TO DO: Написать метод View Order Details

        // TO DO: Написать метод Delete Order
    }
}
