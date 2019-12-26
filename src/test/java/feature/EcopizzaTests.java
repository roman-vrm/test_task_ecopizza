package feature;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.UserSteps;

@RunWith(SerenityRunner.class)
public class EcopizzaTests {

    @Steps
    UserSteps userSteps;

    @Managed(driver = "chrome")
    WebDriver webDriver;

    @Test
    public void productsToTheCart() {
        //Given
        userSteps.openHomePage();

        //Then
        userSteps.shouldBeOnThePage("https://ecopizza.com.ua/");

        //When
        userSteps.openPizzaPage();

        //Then
        userSteps.shouldBeOnThePage("https://ecopizza.com.ua/catalog/pizza");

        //When
        userSteps.filterPizza();

        //And
        userSteps.scrollDownToProduct1();

        //And
        userSteps.chooseProduct1();

        //Then
        userSteps.shouldBeOnThePage("https://ecopizza.com.ua/products/pitstsa-gavajskaya");

        //When
        userSteps.openPizzaPage();

        //And
        userSteps.scrollDownToProduct2();

        //And
        userSteps.chooseProduct2();

        //Then
        userSteps.shouldBeOnThePage("https://ecopizza.com.ua/products/pitstsa-4-syra");

        //When
        userSteps.clickCartButton();

        //And
        userSteps.clickCheckoutButton();

        //Then
        userSteps.shouldBeOnThePage("https://ecopizza.com.ua/cart");

        //And
        userSteps.shouldBeTwoProductsInTheCart();
    }

    @Test
    public void cartTest() throws InterruptedException {
        //Given
        userSteps.openHomePage();

        //Then
        userSteps.shouldBeOnThePage("https://ecopizza.com.ua/");

        //When
        userSteps.openPizzaPage();

        //Then
        userSteps.shouldBeOnThePage("https://ecopizza.com.ua/catalog/pizza");

        //When
        userSteps.filterPizza();

        //And
        userSteps.scrollDownToProduct1();

        //And
        userSteps.chooseProduct1();

        //Then
        userSteps.shouldBeOnThePage("https://ecopizza.com.ua/products/pitstsa-gavajskaya");

        //When
        userSteps.openPizzaPage();

        //And
        userSteps.scrollDownToProduct2();

        //And
        userSteps.chooseProduct2();

        //Then
        userSteps.shouldBeOnThePage("https://ecopizza.com.ua/products/pitstsa-4-syra");

        //When
        userSteps.clickCartButton();

        //And
        userSteps.clickCheckoutButton();

        //Then
        userSteps.shouldBeOnThePage("https://ecopizza.com.ua/cart");

        //And
        userSteps.shouldBeTwoProductsInTheCart();

        //When
        userSteps.fillInRequiredFields();

        //And
        userSteps.setCoupon("Я сохраняю деревья");

        //Then
        userSteps.totalPriceShouldBeChanged();

        //When
        userSteps.chooseDeliveryOption();

        //And
        userSteps.deleteProduct();

        //Then
        userSteps.totalPriceShouldBeChanged();

        Thread.sleep(10000);
    }

}
