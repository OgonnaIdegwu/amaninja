package Amaninja;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutJourney {
    ChromeDriver chromeDriver = new ChromeDriver();


    //User Checkout success//

    @Given("User is on landing page {string}")
    public void user_is_on_landing_page(String string) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/mside/OneDrive/Desktop/chromedriver.exe");
        chromeDriver.get("https://amaninja.co.uk/");
    }

    @Given("User clicks on first item on products list")
    public void user_clicks_on_first_item_on_products_list() {
        WebElement firstItem = chromeDriver.findElement(By.xpath("//*[@id=\"CardLink-template--17083250704692__featured_collection-8067109421364\"]"));
        firstItem.click();
    }

    @Then("User should be directed to products page")
    public void user_should_be_directed_to_products_page() {

        String expectedProductUrl = chromeDriver.findElement(By.xpath("//*[@id=\"MainProduct-template--17083250606388__main\"]")).getAttribute("actualProducturl");
        String actualProductUrl = chromeDriver.getCurrentUrl();
        assert expectedProductUrl.equals(actualProductUrl);
    }

    @Then("User clicks {string} button")
    public void user_clicks_button(String string) {
        WebElement addToCartButton = chromeDriver.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/section[1]/div[1]/div[2]/div[1]/div[6]/product-form[1]/form[1]/div[1]/button[1]"));
        addToCartButton.click();
    }

    @Then("Top basket icon count should update to One")
    public void top_basket_icon_count_should_update_to_one() {
        WebElement basketIcon = chromeDriver.findElement(By.xpath("//*[@id=\"cart-icon-bubble\"]"));
        String basketIconCount = basketIcon.getText();
        assert basketIconCount.equals("1");
    }

    @Then("Dialog should appear showing user {string}")
    public void dialog_should_appear_showing_user(String string) {
        WebElement cartDialog = chromeDriver.findElement(By.xpath("//*[@id=\"cart-notification\"]/div[1]/h2"));
        String cartDialogText = cartDialog.getText();
        assert cartDialogText.contains("item added to cart");

    }

    @Then("this dialog should have {string} and {string} buttons")
    public void this_dialog_should_have_and_buttons(String string, String string2) {

        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        By locator = By.cssSelector("#cart-notification");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        WebElement viewMyCartButton = chromeDriver.findElement(By.cssSelector("#cart-notification-button"));
        Assert.assertTrue(viewMyCartButton.getText().contains("View my cart (1)"));
        WebElement checkoutButton = chromeDriver.findElement(By.cssSelector("#cart-notification-form > button"));
        Assert.assertTrue(checkoutButton.getText().contains("Check out"));

        checkoutButton.click();
    }

    @Then("User should be directed to {string} screen")
    public void user_should_be_directed_to_screen(String string) {
        String actualCheckoutUrl = chromeDriver.getCurrentUrl();
        System.out.println(actualCheckoutUrl);

    }

    //User Can Complete checkout//
    @Given("User is on {string} screen")
    public void user_is_on_screen(String string) {


    }

    @Then("User enters following details on contact information and shipping info")
    public void user_enters_following_details_on_contact_information_and_shipping_info(DataTable dataTable) {
        chromeDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("test@test.com");
        chromeDriver.findElement(By.xpath("//*[@id=\"Select0\"]")).sendKeys("United Kingdom");
        chromeDriver.findElement(By.xpath("//*[@id=\"TextField0\"]")).sendKeys("testname");
        chromeDriver.findElement(By.xpath("//*[@id=\"TextField1\"]")).sendKeys("testSecondName");
        chromeDriver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("test Address");
        chromeDriver.findElement(By.xpath("//*[@id=\"TextField4\"]")).sendKeys("manchester");
        chromeDriver.findElement(By.xpath("//*[@id=\"TextField5\"]")).sendKeys("CW954RE");

        chromeDriver.findElement(By.xpath("//*[@id=\"Form0\"]/div[1]/div/div/div[2]/div[1]/button")).click();
    }
    @Then("User should navigate to {string}")
    public void user_should_navigate_to(String string) {
        String expectedShippingUrl = "https://amaninja.co.uk/shipping";
        String actualShippingUrl = chromeDriver.getCurrentUrl();
        assert expectedShippingUrl.equals(actualShippingUrl);
    }
    @Then("Contact field should show {string}")
    public void contact_field_should_show(String string) {
        String contactField = chromeDriver.findElement(By.cssSelector("")).getText();
        Assert.assertTrue(contactField.contains("test@test.com"));
    }

    @Then("Shipping to should show {string}")
    public void shipping_to_should_show(String string) {
        String shippingToField = chromeDriver.findElement(By.cssSelector("")).getText();
        Assert.assertTrue(shippingToField.contains("test Address, manchester, CW95RE, United Kingdom"));
    }
    @Then("User Clicks {string}")
    public void user_clicks(String string) {
        chromeDriver.findElement(By.xpath("//*[@id=\"Form1\"]/div[1]/div/div/div[2]/div[1]/button")).click();
    }
    @Then("User is navigated to {string}")
    public void user_is_navigated_to(String string) {
        String expectedPaymentUrl = "https://amaninja.co.uk/payment";
        String actualPaymentUrl = chromeDriver.getCurrentUrl();
        assert expectedPaymentUrl.equals(actualPaymentUrl);
    }

    public void exitChrome(){
        chromeDriver.quit();
    }
}

