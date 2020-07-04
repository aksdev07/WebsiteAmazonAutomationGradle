package Practical;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ExceptionExample {
    WebDriver driver;

    @BeforeTest
    public void driverSetup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Advance Users knows what to do with cookies
        //driver.manage().deleteAllCookies();
        driver.get("http://localhost:63342/Automation_Selenium/Automation_Selenium.main/website/DropDown.html?_ijt=q2u5pmhkj0e5rbkavkhrd4kll8#");

    }

    @Test
    public void dropDownExample() throws InterruptedException {
        List<WebElement> option = null;
        String s = "volvo";
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            option = driver.findElements(By.xpath("//h1//select[@id='cars']//option[@id='" + s + "']"));
            System.out.println("1 : " + option.get(1).getAttribute("value"));
            option.get(1).click();
            System.out.println("2 : " + option.get(1).getAttribute("value"));
            System.out.println("DONE");
            driver.wait(2000);

        } catch (StaleElementReferenceException e) {
            System.out.println("Stale element Exception");

            driver.navigate().back();
            System.out.println("1");
            driver.navigate().refresh();
            option = driver.findElements(By.xpath("//h1//select[@id='cars']//option[@id='" + s + "']"));
            System.out.println("2");
            wait.until(ExpectedConditions.visibilityOf(option.get(1)));
            System.out.println("3");
            System.out.println("3 : " + option.get(1).getAttribute("value"));
        } catch (Exception e) {
            System.out.println("EXCEPTION!!!!");
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        /*
         *  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);*/
        driver.quit();
    }
}
