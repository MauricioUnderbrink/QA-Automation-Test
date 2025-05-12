package testcoreutils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitUtils {



    /**
     * Waits for a specific web element to become visible.
     *
     * @param driver           The WebDriver instance.
     * @param element          The WebElement to wait for.
     * @param timeoutInSeconds The timeout in seconds.
     */
    public static void waitForElementVisibility(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            System.out.println("Element not visible within timeout: " + e.getMessage());
        }
    }

    /**
     * Waits for a specific web element to become clickable.
     *
     * @param driver           The WebDriver instance.
     * @param element          The WebElement to wait for.
     * @param timeoutInSeconds The timeout in seconds.
     */
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            System.out.println("Element not visible within timeout: " + e.getMessage());
        }
    }

    /**
     * Waits for a specific web element to become present on the DOM.
     *
     * @param driver           The WebDriver instance.
     * @param locator         The locator to wait for.
     * @param timeoutInSeconds The timeout in seconds.
     */
    public static WebElement waitForPresenceOfElementByLocator(WebDriver driver, By locator, int timeoutInSeconds) {
        try {
        return  new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new RuntimeException("Timeout: Element not visible: " + locator, e);
        }

    }

    /**
     * Fluent wait will call the element again if the element is no longer present in the DOM,
     * @param driver The WebDriver instance.
     * @param locator The locator to wait for.
     * @param timeoutSeconds The duration of teh wait time.
     * @param pollingMilliseconds How often to try finding the element.
     * @return The WebElement.
     */
    public static WebElement waitForElementWithFluentWait(WebDriver driver, By locator, int timeoutSeconds, int pollingMilliseconds) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(pollingMilliseconds))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    return element;
                }
                return null;
            }
        });

    }

    /**
     * This wait is to wait for a page to be completed loaded.
     * @param driver The WebDriver instance.
     * @param timeoutSeconds The duration of teh wait time.
     */
    public static void waitForPageLoadComplete(WebDriver driver, int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }
}
