package Amaninja;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigationPageFirst {

        ChromeDriver chromeDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));


    //As a user I want to make sure navigation work as//

    @Given("User is on AmaNinja Home Page {string}")
    public void user_is_on_ama_ninja_home_page(String string) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/mside/OneDrive/Desktop/chromedriver.exe");
        chromeDriver.get("https://amaninja.co.uk/");
    }
    @Then("clicking each tab navigates to correct URL")
    public void clicking_each_tab_navigates_to_correct_url(DataTable dataTable) {

        String expectedHomeUrl = "https://amaninja.co.uk";
        WebElement tabHomeUrl = chromeDriver.findElement(By.cssSelector("#shopify-section-header > sticky-header > header > nav > ul > li:nth-child(1) > a"));
        tabHomeUrl.click();
        String actualHomeUrl = chromeDriver.getCurrentUrl();
        assert expectedHomeUrl.equals(actualHomeUrl);

        String expectedShopUrl = "https://amaninja.co.uk";
        WebElement tabShopUrl = chromeDriver.findElement(By.cssSelector("#shopify-section-header > sticky-header > header > nav > ul > li:nth-child(2) > a"));
        tabShopUrl.click();
        String actualShopUrl = chromeDriver.getCurrentUrl();
        assert expectedShopUrl.equals(actualShopUrl);

        String expectedContactUsUrl = "https://amaninja.co.uk";
        WebElement tabContactUrl = chromeDriver.findElement(By.cssSelector("#shopify-section-header > sticky-header > header > nav > ul > li:nth-child(3) > a"));
        tabContactUrl.click();
        String actualContactUsUrl = chromeDriver.getCurrentUrl();
        assert expectedContactUsUrl.equals(actualContactUsUrl);

        String expectedAboutUsUrl = "https://amaninja.co.uk";
        WebElement tabAboutUsUrl = chromeDriver.findElement(By.cssSelector("#shopify-section-header > sticky-header > header > nav > ul > li:nth-child(4) > a"));
        tabAboutUsUrl.click();
        String actualAboutUsUrl = chromeDriver.getCurrentUrl();
        assert expectedAboutUsUrl.equals(actualAboutUsUrl);
        }

    //As a User I want to navigate to correct tab when selecting a product//

    @Given("User is on Amaninja Home Page {string}")
    public void user_is_on_amaninja_home_page(String string) {
        chromeDriver.get("https://amaninja.co.uk/");
    }

    @Then("Clicking on a product navigates User to {string} pages")
    public ChromeDriver clicking_on_a_product_navigates_user_to_pages(String string) {
       WebElement product = chromeDriver.findElement(By.cssSelector("#Slide-template--17083250704692__featured_collection-4"));
        product.click();
        chromeDriver.findElement(By.cssSelector("#MainProduct-template--17083250606388__main"));
       String currentUrl = chromeDriver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("product"));

        return chromeDriver;
    }
    @Then("Clicking on {string} shows a dialog")
    public void clicking_on_shows_a_dialog(String string) {
        chromeDriver.get("https://amaninja.co.uk/");
        chromeDriver.findElement(By.cssSelector("#quick-add-template--17083250704692__featured_collection8067090841908-submit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#QuickAdd-8067090841908 > div")));
    }

    @Then("Clicking {string} shows message {string}")
    public void clicking_shows_message(String string, String string2) {
        chromeDriver.findElement(By.cssSelector("#product-form-quickadd-template--17083250606388__main > div > button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart-notification")));
        String actualMessage = chromeDriver.findElement(By.xpath("//*[@id=\"cart-notification\"]/div[1]")).getText();
        Assert.assertEquals("Item added to your cart", actualMessage);
    }
    @Then("User Exits")
    public void user_exits() {
        chromeDriver.quit();
    }
}














