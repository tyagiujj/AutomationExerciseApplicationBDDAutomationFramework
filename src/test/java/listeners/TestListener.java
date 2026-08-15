package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * TestListener class
 * ---------------------
 * Implements TestNG's ITestListener to log test lifecycle events.
 * Screenshot-on-failure logic lives in Hooks.java instead, since
 * Cucumber's Scenario object gives more reliable failure detection
 * with the actual scenario name, before the driver closes.
 */
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }
}