import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static java.lang.Thread.sleep;

public class Test extends BaseTest {
    public static String letterR = "//*[@id='R']";
    public static String letterG = "//*[@id='G']";
    public static String letterB = "//*[@id='B']";

    public static String redColorBackground = "//body[@class='r']";
    public static String greenColorBackground = "//body[@class='g']";
    public static String blueColorBackground = "//body[@class='b']";


    @BeforeTest
    public void beforeTestStep() throws InterruptedException{
        openPage("https://www.rrrgggbbb.com/");
        sleep(1000);
    }

    @org.testng.annotations.Test
    public void mainTest() throws InterruptedException{
        int xMove = 15;
        int yMove = 15;

        //for red letter
        moveToElement(letterR, xMove, yMove);
        colorAndBacgroundColorAssert(letterR, redColorBackground);

        //for green letter
        moveToElement(letterG,  xMove, yMove);
        colorAndBacgroundColorAssert(letterG, greenColorBackground);

        //for blue letter
        moveToElement(letterB, xMove, yMove);
        colorAndBacgroundColorAssert(letterB, blueColorBackground);
    }

    @AfterTest
    public void afterTestStep() {
        driver.quit();
    }


}
