package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage (WebDriver driver){
        super(driver);
    }
    By homePageTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    
    By addToCartButton1By = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartButton2By = By.id("add-to-cart-sauce-labs-bike-light"); 
    By shoppingCartBadgeBy = By.className("shopping_cart_badge");

    By numberOfItemsBy = By.className("inventory_item");
    By shoppingCartBy = By.id("shopping_cart_container");

    public HomePage addAndVerifyProduct(){
        click(addToCartButton1By);
        click(addToCartButton2By);
        waitVisability(shoppingCartBadgeBy);
        assertEquals(driver.findElement(shoppingCartBadgeBy).getText(),"2");
        return this;
    }

    public HomePage numberOfProducts(int expectedNumberOfProducts){
        int actualNumberOfProducts = countItems(numberOfItemsBy);
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }

    public HomePage verifySuccesfulLogin(String expectedText){
        String actualText = readText (homePageTitleBy);
        assertTextEquals (expectedText, actualText);
        return this;
    }

    public HomePage goToCart (){
        click(shoppingCartBy);
        return this;
    }
}
