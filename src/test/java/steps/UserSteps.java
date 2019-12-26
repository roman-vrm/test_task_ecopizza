package steps;

import net.thucydides.core.annotations.Step;
import pageObjects.*;
import static org.assertj.core.api.Assertions.assertThat;

public class UserSteps {

    HomePageObjects homePageObjects;
    CurrentPage currentPage;
    PizzaPageObject pizzaPageObject;
    ProductPageObject productPageObject;
    CartPageObject cartPageObject;

    @Step
    public void openHomePage() {
        homePageObjects.open();
        homePageObjects.getDriver().manage().window().maximize();
        homePageObjects.getDriver().navigate().refresh();
        currentPage.ifModalPresent();
    }

    @Step
    public void shouldBeOnThePage(String expectedTitle) {
        assertThat(currentPage.getDriver().getCurrentUrl()).isEqualTo(expectedTitle);
    }

    @Step
    public void openPizzaPage() {
        homePageObjects.openPizzaPage();
        currentPage.ifModalPresent();
    }

    @Step
    public void scrollDownToProduct1() {
        pizzaPageObject.scrollDownToProduct1();
    }

    @Step
    public void filterPizza() {
        pizzaPageObject.clickOnFilterButton();
        pizzaPageObject.chooseFilterOption();
    }

    @Step
    public void chooseProduct1() {
        pizzaPageObject.chooseProduct1();
        currentPage.ifModalPresent();
        productPageObject.chooseProduct1Size1();
        productPageObject.clickSubmitButton();
    }

    @Step
    public void scrollDownToProduct2() {
        pizzaPageObject.scrollDownToProduct2();
    }

    @Step
    public void chooseProduct2() {
        pizzaPageObject.chooseProduct2();
        currentPage.ifModalPresent();
        productPageObject.chooseProduct1Size2();
        productPageObject.clickSubmitButton();
    }

    @Step
    public void clickCartButton() {
        productPageObject.clickCartButton();
    }

    @Step
    public void clickCheckoutButton() {
        productPageObject.clickCheckoutButton();
    }

    @Step
    public void shouldBeTwoProductsInTheCart() {
        currentPage.ifModalPresent();
        assertThat(cartPageObject.shouldBeTwoProductsInTheCart()).isEqualTo(2);
    }

    @Step
    public void fillInRequiredFields() {
        cartPageObject.fillInRequiredFields();
    }

    @Step
    public void setCoupon(String coupon) {
        cartPageObject.setCoupon(coupon);
    }

    @Step
    public void totalPriceShouldBeChanged() {
        assertThat(cartPageObject.savedTotalPrice()).isGreaterThan(cartPageObject.currentTotalPrice());
    }

    @Step
    public void chooseDeliveryOption() {
        cartPageObject.chooseDeliveryOption();
    }

    @Step
    public void deleteProduct() {
        cartPageObject.deleteProduct();
    }
}
