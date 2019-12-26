package pageObjects;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class PizzaPageObject extends PageObject{

    @FindBy(xpath = "(//img[@title='pitstsa gavayskaya dnepr'])[1]")
    WebElementFacade prod1;

    @FindBy(xpath = "(//img[@title='Пицца Четыре сыра'])[1]")
    WebElementFacade prod2;

    @FindBy (xpath = "//div[@class='products_filter_title sm_switch']")
    WebElementFacade filter;

    @FindBy(xpath = "//label[@class='products_filter_name' and contains(text(), 'Без лука')]")
    WebElementFacade filterOption;


    public void scrollDownToProduct1() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", prod1);
    }

    public void clickOnFilterButton() {
        filter.waitUntilClickable();
        filter.click();
    }

    public void chooseFilterOption() {
        filterOption.waitUntilClickable();
        filterOption.click();
        getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        getDriver().manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }

    public void chooseProduct1() {
        for(int i=0; i<=2;i++){
            try{
                prod1.click();
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void chooseProduct2() {
        for(int i=0; i<=2;i++){
            try{
                prod2.click();
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void scrollDownToProduct2() {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", prod2);
    }
}
