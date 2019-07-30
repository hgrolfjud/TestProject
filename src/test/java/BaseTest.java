import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;


    public BaseTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        settingDriver(driver);
    }

    void goToURL(String url) {
        driver.get(url);
    }


    private static void settingDriver(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

}
