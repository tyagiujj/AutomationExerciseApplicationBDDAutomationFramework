package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * WaitUtils class
 * ------------------
 * Centralizes all Explicit Wait logic used across Page Object classes.
 *
 * WHY this exists:
 * Instead of writing "new WebDriverWait(driver, ...)" repeatedly in
 * every Page Object method, this class provides reusable wait methods.
 * This follows the DRY principle and makes it easy to change wait
 * behavior (e.g., timeout duration) in one place.
 *
 * Explicit waits are preferred over relying solely on Implicit Wait
 * because they target a SPECIFIC condition on a SPECIFIC element,
 * making tests more reliable against dynamic content (like ads,
 * popups, or slow-loading elements) instead of a blanket timeout.
 */
public class WaitUtils {

    private static final Logger logger = LogManager.getLogger(WaitUtils.class);

    private static int getExplicitWaitSeconds() {
        return Integer.parseInt(ConfigReader.get("explicitWait"));
    }

    /**
     * Waits until the given element is visible on the page.
     * Use before interacting with elements that may load dynamically.
     */
    public static void waitForVisibility(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWaitSeconds()));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits until the given element is clickable (visible AND enabled).
     * Use before clicking buttons that may be temporarily disabled
     * or covered by overlays (like ads) while the page finishes loading.
     */
    public static void waitForClickability(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWaitSeconds()));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits until the page title contains the given text.
     * Use after actions that trigger navigation (e.g., search, login)
     * to confirm the new page has actually loaded before proceeding.
     */
    public static void waitForTitleContains(WebDriver driver, String titleFragment) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(getExplicitWaitSeconds()));
        wait.until(ExpectedConditions.titleContains(titleFragment));
        logger.info("Title now contains: " + titleFragment);
    }
}