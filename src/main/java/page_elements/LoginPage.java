package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcoreutils.WaitUtils;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameFieldLocator = By.xpath("//label[normalize-space()='Username*']/parent::div//input");

    private By passwordFieldLocator = By.xpath(
            "//label[normalize-space()='Password*']/parent::div//input");

    private By loginButtonLocator = By.xpath("//button[@type='submit']//span[normalize-space()='Login']");

    public WebElement getUserNameElement(){
        return WaitUtils.waitForPresenceOfElementByLocator(driver, usernameFieldLocator, 10);
        //return usernameField;
    }
    public void enterUsername(String username){
        getUserNameElement().click();
        getUserNameElement().sendKeys(username);
    }

    public WebElement gePasswordElement(){
        return WaitUtils.waitForPresenceOfElementByLocator(driver, passwordFieldLocator, 10);
    }
    public void enterPassword(String password){
        gePasswordElement().click();
        gePasswordElement().sendKeys(password);
    }

    public void clickLoginButton(){
     WebElement LoginButton = driver.findElement(loginButtonLocator);
        if(LoginButton.isDisplayed() && LoginButton.isEnabled()){
            LoginButton.click();
        }

    }
}
