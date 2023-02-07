package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverview extends BasePage {
    public CheckoutOverview (WebDriver driver){
        super(driver);
    }
    By itemPriceBy =By.className("summary_subtotal_label"); 
    By taxPriceBy = By.cssSelector(".summary_tax_label");
    By totalBy = By.cssSelector(".summary_total_label");
    By finishButtonBy = By.id("finish");
  
    public CheckoutOverview checkPrice (){
        double itemPrice = Double.parseDouble(readText(itemPriceBy).replace("Item total: $",""));
        double itemTax = Double.parseDouble(readText(taxPriceBy).replace("Tax: $", ""));
        String itemTotal = readText(totalBy).replace("Total: $", "");
        double total = itemPrice + itemTax;
        String stringTotal = Double.toString(total);
        assertTextEquals(itemTotal,stringTotal);
        return this;
    }

    public CheckoutOverview finishShopping(){
        click(finishButtonBy);
        return this;
    }


}
