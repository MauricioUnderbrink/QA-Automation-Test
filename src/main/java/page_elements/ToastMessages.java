package page_elements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testcoreutils.WaitUtils;

import javax.swing.text.Utilities;
import java.time.Duration;

public class ToastMessages {

    private WebDriver driver;
    public ToastMessages(WebDriver driver) {
        this.driver = driver;
    }
    private final By toastMessageContainerLocator = By.className("Toastify__toast-container");
    private final By toastBodyLocator = By.cssSelector("div[data-testid='toast-body']");
    private final By toastContentLocator = By.cssSelector("div[data-testid='toast-content']");
    private final By closeToastButtonLocator = By.cssSelector("button.Toastify__close-button");

    public WebElement getToastContainerElement(){
        return WaitUtils.waitForPresenceOfElementByLocator(driver, toastMessageContainerLocator,4);
    }
    public boolean isToastMessagePresent() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(1));
            return shortWait.until(ExpectedConditions.presenceOfElementLocated(toastMessageContainerLocator)).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public String getToastMessageText() {
        try {
            if (isToastMessagePresent()) {
                return driver.findElement(toastContentLocator).getText().trim();
            }
        } catch (NoSuchElementException ignored) {
        }
        return "";
    }

    public void closeToastMessage() {
        try {
            if (isToastMessagePresent()) {
                WebElement closeBtn = driver.findElement(closeToastButtonLocator);
                if (closeBtn.isDisplayed() && closeBtn.isEnabled()) {
                    closeBtn.click();
                }
            }
        } catch (NoSuchElementException | ElementNotInteractableException ignored) {

        }
    }
}
