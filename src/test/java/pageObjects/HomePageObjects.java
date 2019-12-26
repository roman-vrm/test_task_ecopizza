package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://ecopizza.com.ua")
public class HomePageObjects extends PageObject{

    @FindBy(xpath = "//a[@href='catalog/pizza']")
    WebElementFacade pizzaPageLink;


    public void openPizzaPage() {
        pizzaPageLink.waitUntilClickable();
        pizzaPageLink.click();
    }

}
