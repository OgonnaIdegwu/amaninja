package Amaninja;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomeScreenStepsDef {

    ChromeDriver chromeDriver = new ChromeDriver();
    @Given("User is logged in and on home Screen")
    public void user_is_logged_in_and_on_home_screen() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/mside/OneDrive/Desktop/chromedriver.exe");
        chromeDriver.get("https://amaninja.co.uk/");
    }
    @Then("User should be able to see {int} Product items")
    public void user_should_be_able_to_see_product_items(Integer expectedNumberOfItems) {
        List<WebElement> productItems = chromeDriver.findElements(By.cssSelector("#Slide-template--17083250704692__featured_collection-1,#Slide-template--17083250704692__featured_collection-2, #Slide-template--17083250704692__featured_collection-3, #Slide-template--17083250704692__featured_collection-4"));
               int actualNumberOfItems = productItems.size();
              assertEquals(expectedNumberOfItems.intValue(), actualNumberOfItems);
    }

    @Then("product items should have the following components")
    public void product_items_should_have_the_following_components(DataTable dataTable) {
        // Get the list of expected components
        List<String> expectedComponents = dataTable.asList();
        By image = By.cssSelector ("#Slide-template--17083250704692__featured_collection-1 > div > div > div.card__inner.color-background-2.gradient.ratio > div.card__media > div") ;
        By Description = By.cssSelector("#CardLink-template--17083250704692__featured_collection-8067518169396");
        By Price = By.cssSelector("#Slide-template--17083250704692__featured_collection-1 > div > div > div.card__content > div.card__information > div > div.price.price--sold-out");
        By statusBar = By.cssSelector("#NoMediaStandardBadge-template--17083250704692__featured_collection-8067518169396");
        By chooseOptionButton = By.cssSelector("#quick-add-template--17083250704692__featured_collection8067518169396-submit");

        // Find the product items container
        WebElement productContainer = chromeDriver.findElement(By.cssSelector("#Slide-template--17083250704692__featured_collection-1"));

        // Get a list of all product items
        List<WebElement> productItems = productContainer.findElements(By.cssSelector("#shopify-section-template--17083250704692__featured_collection > div > div > slider-component"));

        // Validate the components of each product item
        for (WebElement productItem : productItems) {
            for (String expectedComponent : expectedComponents) {
                // Validate each component
                WebElement component = productItem.findElement(By.cssSelector("#shopify-section-template--17083250704692__featured_collection > div > div > slider-component" + expectedComponent));
                assertTrue(expectedComponent + " is not displayed", component.isDisplayed());
            }
        }
    }

}




