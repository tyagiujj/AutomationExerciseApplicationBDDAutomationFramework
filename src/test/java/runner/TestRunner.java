package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",   // where feature files are
        glue = {"stepDefinitions", "hooks"},          // where step definitions + hooks are
        plugin = {"pretty"},                          // readable console output
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}