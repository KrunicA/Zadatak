package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardPage extends BasePage{
    public CardPage (WebDriver driver){
        super(driver);

    }

    By checkoutButtonBy = By.id("checkout");
    
    
    public CardPage goToCheckout (){
        click(checkoutButtonBy);
        return this;
    }

}
