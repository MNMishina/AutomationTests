package oauth;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import pojo.WebAutomation;
import pojo.Api;
import pojo.GetCourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class OauthTest {

    public static void main(String[] args) throws InterruptedException {

        String[] courseTitles = {"Selenium Webdriver Java", "Cypress", "Protractor"};   // массив из ожидаемых названий курсов

//        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://accounts.google.com/o/oauth2/v2/auth/identifier?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&service=lso&o2v=2&flowName=GeneralOAuthFlow");
//        //  tagname[attribute='value']
//        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("srinath19830");
//        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
//        Thread.sleep(3000);
//        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("123456");
//        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
//        Thread.sleep(4000);
        //String url = driver.getCurrentUrl();

        String url ="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_XR14PHtTZf7ILSEeamywJKwo_BYs9M&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#";
        String partialCode = url.split("code=")[1];
        String code = partialCode.split("&scope")[0];
        System.out.println(code);

        String accessTokenResponse = given().urlEncodingEnabled(false)   // rest-assured don't recognize special characters like '%' Используется метод urlEncodingEnabled(false) чтобы не конвертировал % в цифру
                .queryParams("code", code)
                .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                .queryParams("grant_type", "authorization_code")
                .queryParams("state", "verifyfjdss")
                .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
                .when().log().all()
                .post("https://www.googleapis.com/oauth2/v4/token").asString();

        JsonPath js = new JsonPath(accessTokenResponse);
        String accessToken = js.getString("access_token");
        System.out.println(accessToken);

        GetCourse gc = given()
                .queryParam("access_token", accessToken)
                .expect().defaultParser(Parser.JSON)//  указываем в каком виде хотим получить респонс log().all() - нельзя писать, потому что возникнет ошибка
                .when()
                .get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);   //  оборачиваем респонс в класс (родительский класс GetCourse)
        System.out.println(gc);
        System.out.println(gc.getLinkedIn());
        System.out.println(gc.getInstructor());

        System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());

        List<Api> apiCourses = gc.getCourses().getApi();
        for(int i=0; i<apiCourses.size(); i++) {
            if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
            {
                System.out.println(apiCourses.get(i).getPrice());
                gc.getCourses().getMobile().get(1).getCourseTitle();
            }
        }
        // Get the course titles of WebAutomation
        ArrayList<String> a = new ArrayList<String>();

        List<WebAutomation> w = gc.getCourses().getWebAutomation();
        for(int j=0; j<w.size(); j++) {
            a.add(w.get(j).getCourseTitle());
        }
        List<String> expectedList = Arrays.asList(courseTitles);

        Assert.assertTrue(a.equals(expectedList));

    }
}
