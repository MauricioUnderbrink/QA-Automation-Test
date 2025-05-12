package testUtils;

import org.openqa.selenium.WebDriver;
import page_elements.LoginPage;
import page_elements.LogoutUserElements;
import testcoreutils.CredentialReader;

public class LoginHelper {

    private WebDriver driver;
    private LoginPage loginPage;
    private LogoutUserElements logoutUserElements;

    public LoginHelper(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.logoutUserElements = new LogoutUserElements(driver);
    }

    public void loginUser(String userType) {
        String username = CredentialReader.getUserName(userType);
        String password = CredentialReader.getPassword(userType);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    public void logoutUser(){
        logoutUserElements.clickUserAvatarIcon();
        logoutUserElements.clickLogOutButton();
    }
}
