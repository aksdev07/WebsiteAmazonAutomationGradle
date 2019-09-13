package com.amazon;

public interface AmazonResources {

    //Varibales for normal string values
    String url ="https://www.amazon.in" ;
    String itemName="Crucial 4GB";


    //Methods

    void mouseHoverFunctionality(String xpath) throws InterruptedException;
    void intialBrowserSetup(String url);
    void loginFunctionality(String mobile, String password);
    void itemSearchFunctionality(String itemName);
    void itemSelectFunctionality() throws InterruptedException;
    void switchTabFucntionality() throws InterruptedException;
    void buyNowFunctionality() throws InterruptedException;
    void imageChangeFucntionality();
    void scrollFunctionality();
    void filterClick(String x);



    //XPATHS
     //1. click/hover on a link
    String loginXValue = "//a[@id='nav-link-accountList']";
    String loginButton = "//span[contains(text(),'Sign in')]//ancestor::div[@id='nav-flyout-accountList']//child::a[@class='nav-action-button']//child::span[@class='nav-action-inner']";
    String loginUserID = "Your_UserID";
    String loginPassword="Your_Password";
    String userNameField = "//input[@id='ap_email']";
    String loginContinue = "//input[@id='continue']";
    String passwordField = "//input[@id='ap_password']";
    String loginButtonClick ="//input[@id='signInSubmit']";
    String itemSearchField =" //input[@id='twotabsearchtextbox']";
    String getItemSearchFieldClick = "//input[@value='Go']";
    String itemList = "//span[@class='a-size-medium a-color-base a-text-normal' ]";
    String buyNowButton ="//input[@id='buy-now-button']";
    String imageHover ="//span[@id='a-autoid-9']//following-sibling::span";
    String customerRating="//span[@class='a-icon-alt' ]";













}
