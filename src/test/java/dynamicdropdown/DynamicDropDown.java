package dynamicdropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynamicDropDown {
    ChromeDriver driver;

    @BeforeTest
    public void driverSetup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Advance Users knows what to do with cookies
        //driver.manage().deleteAllCookies();
        driver.get("http://localhost:63343/Automation_Selenium/Automation_Selenium.main/website/DropDown.html?_ijt=gkqiihr9vcf04t1tgqv5gnrs8n");

    }

    @Test
    public void dropDownExample() throws InterruptedException {
        List<WebElement> option = null;
        String s = "audi";
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            String xpath="//h1//select[@id='cars']//option[@id,'%s']";
            option = driver.findElements(By.xpath(String.format(xpath,s)));
            System.out.println("1 : " + option.get(1).getAttribute("value"));
            driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
           // Thread.sleep(5000);
            option.get(1).click();
            System.out.println("2 : " + option.get(1).getAttribute("value"));
            System.out.println("DONE");
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

        driver.quit();
    }
}
