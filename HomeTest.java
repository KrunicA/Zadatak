package tests;

import org.junit.Test;
import pages.CardPage;
import pages.HomePage;
import pages.LoginPage;
import pages.CheckoutYourInformation;
import pages.CheckoutOverview;
import pages.CheckoutComplete;

public class HomeTest extends BaseTest{

    public LoginPage loginPage;
    public HomePage homePage;
    public CardPage cardPage;
    public CheckoutYourInformation checkoutYourInformation;
    public CheckoutOverview orderOverviewPage;
    public CheckoutComplete checkoutComplete;

    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String expectedText = "PRODUCTS";
    
    int numberOfAllItems = 6;

 
    @Test
    public void verifyNumberOfItemsOnHomePage(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);
        homePage.numberOfProducts(numberOfAllItems);
    
    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
    }

    @Test
    public void addTwoItemsAndVerify(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
       
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);
        homePage.addAndVerifyProduct();

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }  
    }

    @Test
    public void verifyItemsPriceAndTax (){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cardPage = new CardPage(driver);
        checkoutYourInformation = new CheckoutYourInformation(driver);
        orderOverviewPage = new CheckoutOverview(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);
        homePage.addAndVerifyProduct();
        homePage.goToCart();
        cardPage.goToCheckout();
        checkoutYourInformation.continueToOverview();
        orderOverviewPage.checkPrice();
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }  
    }

    @Test
    public void verifyCompletePurchase(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cardPage = new CardPage(driver);
        checkoutYourInformation = new CheckoutYourInformation(driver);
        orderOverviewPage = new CheckoutOverview(driver);
        checkoutComplete = new CheckoutComplete(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);
        homePage.addAndVerifyProduct();
        homePage.goToCart();
        cardPage.goToCheckout();
        checkoutYourInformation.continueToOverview();
        orderOverviewPage.checkPrice();
        orderOverviewPage.finishShopping();
        checkoutComplete.verifyCompleteCheckout();

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }  
    }
}


    

