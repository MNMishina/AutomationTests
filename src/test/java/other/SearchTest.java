package other;/*import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;*/
import org.testng.annotations.Test;

//import java.io.File;

public class SearchTest {
    @Test
    // void - ничего не возвращает
    public void openGoogleComInChromeTest() {
        /*
        //Путь к драйверу
        File file = new File("src/test/resources/chromedriver.exe");
        //Сохраняем путь в системную переменную
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        //Пример локального web драйвера для Хрома
        WebDriver driver = new ChromeDriver();
        //метод navigate и to переводят на url
        driver.navigate().to("https://www.google.com/"); // или driver.get("https://www.google.com/");
        *//*
        driver.navigate().to - переход на url
        driver.navigate().refresh - обновить
        driver.navigate().back - назад
        driver.navigate().forward - вперед
         */
        /*
        Закрытие браузера
        driver.quit - закрытие браузера со всеми окнами
        driver.close - закрывает текущее окно
         *//*

        System.out.println(driver.getTitle());
        driver.quit();
*/
        //Пример локального web драйвера для ИЕ
        /*
        WebDriver driver = new InternetExplorerDriver();
        //метод navigate и to переводят на url
        driver.navigate().to("https://www.microsoft.com/");
        */

        //Пример удаленного web драйвера
        /*
        WebDriver driver = new RemoteWebDriver(remoteURL, desiredCapabilities);
        */
    }
}
