package listeners;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test Skipped: " + result.getName());
    }

    /**
     * Called automatically once, after the ENTIRE test suite finishes.
     * This is the right place to generate the pie-chart dashboard report,
     * because we need ALL scenario results to already be written into
     * the cucumber.json file before we can build a complete report.
     */
    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test suite finished. Generating Cucumber pie-chart report...");
        generatePieChartReport();
    }

    private void generatePieChartReport() {
        // Path to the JSON file Cucumber generated during the run
        String jsonPath = System.getProperty("user.dir") + "/target/cucumber-reports/cucumber.json";
        List<String> jsonPaths = Arrays.asList(jsonPath);

        // Folder where the new dashboard-style report will be created
        File reportOutputDirectory = new File(System.getProperty("user.dir") + "/target/cucumber-pie-report");

        Configuration configuration = new Configuration(reportOutputDirectory, "AutomationExercise Test Suite");

        // Optional but nice: shows machine/build info on the report
        configuration.setBuildNumber("1.0");

        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, configuration);
        reportBuilder.generateReports();

        logger.info("Pie-chart report generated at: " + reportOutputDirectory.getAbsolutePath());
    }
}