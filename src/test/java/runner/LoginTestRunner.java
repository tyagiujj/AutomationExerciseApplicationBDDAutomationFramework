package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import listeners.TestListener;
import org.testng.annotations.Listeners;

@CucumberOptions(
        features = "src/test/resources/features/TC_02LoginUserwithcorrectemailandpassword.feature",
        glue = {"stepDefinitions", "hooks"},
        plugin = {"pretty"},
        monochrome = true
)
@Listeners(TestListener.class)
public class LoginTestRunner extends AbstractTestNGCucumberTests {
}