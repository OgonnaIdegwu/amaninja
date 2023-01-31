package Utility;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ("classpath:features"),
        glue = ("Amaninja")
)
public class CucumberRunner {
}
