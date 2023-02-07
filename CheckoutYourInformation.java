package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformation extends BasePage {
    public CheckoutYourInformation (WebDriver driver){
        super(driver);
    }

    By firstNameBy = By.id("first-name");
    By lastNameBy = By.id("last-name");
    By zipBy = By.id("postal-code");
    By continueButtonBy = By.id("continue");

    public CheckoutYourInformation continueToOverview (){
        writeText(firstNameBy, "Anja");
        writeText(lastNameBy, "Krunic");
        writeText(zipBy, "11000");
        click(continueButtonBy);
        return this;
    }




}
