package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcoreutils.WaitUtils;

public class MainSidebarPage {

    private WebDriver driver;

    private By dashboardMenuLocator = By.xpath("//span[normalize-space()='Dashboard']");
    private By manageUsersMenuLocator = By.xpath("//span[normalize-space()='Manage Users']");

    public MainSidebarPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTheDashboardMenu(){
        driver.findElement(dashboardMenuLocator).click();
    }

    public WebElement getManageUsersMenuElement(){
       return WaitUtils.waitForPresenceOfElementByLocator(driver, manageUsersMenuLocator, 10);
    }

    public void clickTheManageUsersMenu(){
        getManageUsersMenuElement().click();
    }

}
