package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutComplete extends BasePage{
    public CheckoutComplete (WebDriver driver){
        super(driver);
    }


    By text =By.className("complete-header"); 

    public CheckoutComplete verifyCompleteCheckout(){
        String assertMessage = readText(text);
        assertTextEquals(assertMessage, "THANK YOU FOR YOUR ORDER");
        return this;
    }
}
