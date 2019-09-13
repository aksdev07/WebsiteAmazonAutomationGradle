package com.amazon;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

 public  class AmazonAutomation implements AmazonResources {
    private Object WebDriverManager;

   private static WebDriver driver;


    public void intialBrowserSetup(String URL) {

        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Advance Users knows what to do with cookies
        //driver.manage().deleteAllCookies();

        //driver wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(URL);

    }


    public void mouseHoverFunctionality(String xpath) throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath(xpath));
        Thread.sleep(1000);
        action.moveToElement(we).build().perform();

    }

    @Override
    public void loginFunctionality(String mobile, String password) {

             driver.findElement(By.xpath(AmazonResources.loginButton)).click();
          driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
             driver.findElement(By.xpath(AmazonResources.userNameField)).sendKeys(mobile);
             driver.findElement(By.xpath(AmazonResources.loginContinue)).click();
             driver.findElement(By.xpath(AmazonResources.passwordField)).sendKeys(password);
             driver.findElement(By.xpath(AmazonResources.loginButtonClick)).click();



    }

    @Override
    public void itemSearchFunctionality(String itemName) {
        driver.findElement(By.xpath(AmazonResources.itemSearchField)).sendKeys(itemName);
        driver.findElement(By.xpath(AmazonResources.getItemSearchFieldClick)).click();



    }

    @Override
    public void itemSelectFunctionality()  {

        while(true)
        {
            try {

                java.util.List<WebElement> items= driver.findElements(By.xpath( AmazonResources.itemList));
                System.out.println("List size is  "+items.size());
                items.get(1).click();
                break;
            }
            catch(StaleElementReferenceException e) {
                System.out.println("e.getMessage() = " + e.getMessage());
               driver.navigate().refresh();

            }
        }
        switchTabFucntionality();
    }

    @Override
    public void switchTabFucntionality()  {
        String Tab1 = driver.getWindowHandle();
        ArrayList<String> availableWindows = new ArrayList<>(driver.getWindowHandles());
        System.out.println("availableWindows = " + availableWindows);
        if (!availableWindows.isEmpty()) {
            driver.switchTo().window(availableWindows.get(1));
            System.out.println("inside tab 1");
        }
    }

    @Override
    public void buyNowFunctionality()  {
        System.out.println("inside buyNowFunctionality");
        driver.findElement(By.xpath(AmazonResources.buyNowButton)).click();
    }

    @Override
    public void imageChangeFucntionality() {

                java.util.List<WebElement> items= driver.findElements(By.xpath( AmazonResources.imageHover));
                System.out.println("Image List size is  "+items.size());
                for(int i=0;i<=items.size();i++) {

                    items.get(i).click();
                }

            }




    @Override
    public void scrollFunctionality() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        js.executeScript("window.scrollBy(1000,0)");
    }

    @Override
    public void filterClick(String x) {
        java.util.List<WebElement> items= driver.findElements(By.xpath( AmazonResources.customerRating));
        System.out.println("List size is  "+items.size());
        items.get(0).click();


    }

    public void driverMethod() throws InterruptedException {


      Thread.sleep(15000);
      driver.quit();

  }

}
