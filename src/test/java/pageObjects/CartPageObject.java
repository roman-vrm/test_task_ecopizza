package pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPageObject extends PageObject{

    @FindBy(xpath = "//td[@class='name' and contains(text(), 'Пицца')]")
    List<WebElement> products;

    @FindBy(xpath = "//div[@class='cart_form fleft']//input[@name='name']")
    WebElementFacade nameField;

    @FindBy(xpath = "//div[@class='cart_form fleft']//input[@name='phone']")
    WebElementFacade phoneField;

    @FindBy(xpath = "//div[@class='cart_form fleft']//input[@name='address[home]']")
    WebElementFacade houseNumb;

    @FindBy(xpath = "//input[@name='coupon_code']")
    WebElementFacade couponField;

    @FindBy(xpath = "//input[@name='apply_coupon']")
    WebElementFacade applyCouponButton;

    @FindBy(xpath = "//span[@class='total_summ']/b")
    WebElementFacade totalPrice;

    @FindBy(xpath = "//select[@name='delivery_id']")
    WebElementFacade deliveryDropDown;

    @FindBy(xpath = "(//a[@title='Удалить из корзины'])[2]")
    WebElementFacade deleteButton;

    public int shouldBeTwoProductsInTheCart() {
        products.get(0).isDisplayed();
        return products.size();
    }

    public void fillInRequiredFields() {
        nameField.waitUntilVisible();
        nameField.sendKeys("Роман");
        phoneField.sendKeys("+380952248636");
        houseNumb.sendKeys("48");
    }

    public void setCoupon(String coupon) {
        totalPrice.waitUntilVisible();
        GlobalStaticData.price s = new GlobalStaticData.price();
        s.setPrice(Integer.parseInt(totalPrice.getText().replace(".", "")));
        couponField.waitUntilVisible();
        couponField.sendKeys(coupon);
        applyCouponButton.click();
    }

    public Integer currentTotalPrice() {
        totalPrice.waitUntilVisible();
        return Integer.parseInt(totalPrice.getText().replace(".", ""));
    }

    public Integer savedTotalPrice() {
        GlobalStaticData.price s = new GlobalStaticData.price();
        return s.getPrice();
    }

    public void chooseDeliveryOption() {
        deliveryDropDown.waitUntilVisible();
        Select dropdownItems = new Select(deliveryDropDown);
        dropdownItems.selectByValue("2");
    }

    public void deleteProduct() {
        totalPrice.waitUntilVisible();
        GlobalStaticData.price s = new GlobalStaticData.price();
        s.setPrice(Integer.parseInt(totalPrice.getText().replace(".", "")));
        deleteButton.waitUntilVisible();
        deleteButton.waitUntilClickable();
        deleteButton.click();
    }
}
