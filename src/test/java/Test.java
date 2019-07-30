import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static java.lang.Thread.sleep;

public class Test extends BaseTest {
    @BeforeTest
    public void preConditionStep() throws InterruptedException{
        goToURL("https://www.google.com/");
        sleep(2000);
    }

    @AfterTest
    public void postConditionStep() {
        driver.quit();
    }
}
