package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcoreutils.WaitUtils;

public class LogoutUserElements {

    private WebDriver driver;

    private By userAvatarLocator = By.cssSelector(".v-badge.v-badge--bordered.v-badge--dot");

    private By logoutButtonLocator = By.xpath("div[@class='v-overlay__content']//span[normalize-space()='Logout']");

    public LogoutUserElements(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getUserAvatarElement(){
        return driver.findElement(userAvatarLocator);
    }

    public void clickUserAvatarIcon() {
        if (getUserAvatarElement().isDisplayed()) {
            WaitUtils.waitForElementVisibility(driver, getUserAvatarElement(), 10);
            getUserAvatarElement().click();
        }
    }

    public WebElement getLogoutButtonLocator(){
        return driver.findElement(logoutButtonLocator);
    }

    public void clickLogOutButton(){
        WaitUtils.waitForElementVisibility(driver, getLogoutButtonLocator(),10);
        getLogoutButtonLocator().click();
    }


}
