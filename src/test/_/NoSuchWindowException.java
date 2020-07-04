import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class NoSuchWindowException {
    WebDriver driver;
    @BeforeTest
    public void driverSetup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Advance Users knows what to do with cookies
        //driver.manage().deleteAllCookies();
        //driver wait
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://way2automation.com/way2auto_jquery/submit_button_clicked.php");
    }

    @Test
    public void exceptionExample() {
        ArrayList<String> availableWindows = new ArrayList<>(driver.getWindowHandles());
//      try {
//            driver.switchTo().window(availableWindows.get(2));
//        }catch (NoSuchWindowException e){
//          e.printStackTrace();
//      }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }







}
