package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class ProductPageObject extends PageObject{

    @FindBy(id = "product_55")
    WebElementFacade prod1Size25;

    @FindBy(xpath = "//td[@id='cart_oldBuy']//input[@type='submit']")
    WebElementFacade submitButton1;

    @FindBy(id = "product_327")
    WebElementFacade prod2Size25;

    @FindBy(xpath = "//a[@class='call_cart button_bg_text']")
    WebElementFacade cartButton;

    @FindBy(xpath = "//a[@href='cart/']")
    WebElementFacade checkoutButton;


    public void chooseProduct1Size1() {
        prod1Size25.waitUntilVisible();
        prod1Size25.waitUntilClickable();
        prod1Size25.click();
    }

    public void clickSubmitButton() {
        submitButton1.waitUntilVisible();
        submitButton1.click();
    }

    public void chooseProduct1Size2() {
        prod2Size25.waitUntilVisible();
        prod2Size25.waitUntilClickable();
        prod2Size25.click();
    }

    public void clickCartButton() {
        cartButton.waitUntilVisible();
        cartButton.waitUntilClickable();
        cartButton.click();
    }

    public void clickCheckoutButton() {
        checkoutButton.waitUntilVisible();
        checkoutButton.waitUntilClickable();
        checkoutButton.click();
    }
}
