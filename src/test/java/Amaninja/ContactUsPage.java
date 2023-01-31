package Amaninja;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactUsPage {

             ChromeDriver chromeDriver = new ChromeDriver();

    @Given("User is logged in and on Contact us page")
    public void user_is_logged_in_and_on_contact_us_page() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/mside/OneDrive/Desktop/chromedriver.exe");
        chromeDriver.get("https://amaninja.co.uk/pages/contact");
    }
    @Then("Details should be filled in contact us form")
    public void details_should_be_filled_in_contact_us_form(DataTable dataTable) {
        WebElement nameField = chromeDriver.findElement(By.xpath("//*[@id=\"ContactForm-name\"]"));
        nameField.sendKeys("Abdul");
        WebElement emailField = chromeDriver.findElement(By.xpath("//*[@id=\"ContactForm-email\"]"));
        emailField.sendKeys("salam@gmail.com");
        WebElement commentField = chromeDriver.findElement(By.xpath("//*[@id=\"ContactForm-body\"]"));
        commentField.sendKeys("This is a comment");
    }
    public void exitChrome(){
        chromeDriver.close();
    }
}
