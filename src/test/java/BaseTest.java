import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


public class BaseTest {
    public static WebDriver driver;

    public BaseTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        settingDriver(driver);
    }

    void openPage(String url) {
        driver.get(url);
    }

    private static void settingDriver(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void moveToElement(String elementLocation) {
        moveToElement(elementLocation, 0, 0);
    }

    public void moveToElement(String elementLocation, int xOffset, int yOffset) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(elementLocation)), xOffset, yOffset).build().perform();
    }

    public boolean isElementWithClass(String baseElement, String activeClass) {
        return driver.findElement(By.xpath(baseElement)).findElements(By.xpath(".//*[contains(@class,'" + activeClass + "')]")).size() > 0;
    }

    public boolean isElementPresent(String elementLocation) {
        try {
            driver.findElement(By.xpath(elementLocation));
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }

    public void colorAndBacgroundColorAssert(String color, String background){
        try{
            sleep(500);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        Assert.assertTrue(isElementWithClass(color, "black"));
        Assert.assertTrue(isElementPresent(background));
    }

}
