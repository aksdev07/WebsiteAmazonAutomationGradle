import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
*
* 1. The locator you are using to find the element is incorrect
  2. Something has gone wrong and the element has not been rendered
  3. You tried to find the element before it was rendered
* */
public class NoSuchElementException {
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
        //driver.get("http://way2automation.com/way2auto_jquery/submit_button_clicked.php");
        driver.get("http://localhost:63342/Automation_Selenium/Automation_Selenium.main/website/simple.html?_ijt=8uqk5kijpkl74v9c9lr3hj9vr5");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void exceptionExample() {
        try {
            driver.findElement(By.xpath("//input[@name='nam']"));
            System.out.println("HI");
        }catch (org.openqa.selenium.NoSuchElementException e){
            System.out.println("Exception encountered");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("Second Exception");
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
