package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;

public class CurrentPage extends PageObject{

    @FindBy(xpath = "//label[@class='popup-closer']")
    WebElementFacade modalCloseButton;

    public Boolean modalWindow() {
        try {
            modalCloseButton.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void ifModalPresent() {
        if (modalWindow() == true) {
            modalCloseButton.waitUntilClickable();
            modalCloseButton.click();
        }
        else {
            System.out.println("Modal window is not present!");
        }
    }
}
