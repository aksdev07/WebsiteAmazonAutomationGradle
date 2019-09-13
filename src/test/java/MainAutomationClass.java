import com.amazon.AmazonAutomation;
import com.amazon.AmazonResources;

public class MainAutomationClass {
    public static void main(String[] args) throws InterruptedException {
        AmazonAutomation Var = new AmazonAutomation();


        //This is to instantiate browser and navigate to the desired url
        Var.intialBrowserSetup(AmazonResources.url);
        //This will hover over the login button
        Var.mouseHoverFunctionality(AmazonResources.loginXValue);
        //this is to log in to the application Change USER_ID and Password in AmazonResources.java
         Var.loginFunctionality(AmazonResources.loginUserID,AmazonResources.loginPassword);
        //this will enter item name in the textfield
        Var.itemSearchFunctionality(AmazonResources.itemName);
        //this will filter out the prodcut in terms of highest rating
        Var.filterClick(AmazonResources.customerRating);
        //this will select the 2nd product from the given list on the screen
        Var.itemSelectFunctionality();
        //this will purchase the product
        Var.buyNowFunctionality();
        //javascript code to scroll up and down
        Var.scrollFunctionality();


    }


}
