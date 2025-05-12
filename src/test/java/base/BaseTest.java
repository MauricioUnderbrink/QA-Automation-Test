package base;

import org.openqa.selenium.WebDriver;
import page_elements.*;
import testUtils.LoginHelper;
import testcoreutils.WaitUtils;
import testcoreutils.WebDriverFactory;

public class BaseTest {

    protected WebDriver driver;
    protected MainSidebarPage mainSidebarPage;
    protected LoginPage loginPage;
    protected AddUserPage addUserPage;
    protected LogoutUserElements logoutUserElements;
    protected ModifyUserPage modifyUserPage;
    protected UsersListPage usersListPage;

    protected ToastMessages toastMessages;

    protected final String Home_URL = "https://beta.snippetsentry.com/app/client/dashboard";
    protected final String LoginPage_URL = "https://beta.snippetsentry.com/login";

    public void setUp(String browser) {
        driver = WebDriverFactory.createDriver(browser);
        driver.get(LoginPage_URL);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        mainSidebarPage = new MainSidebarPage(driver);
        addUserPage = new AddUserPage(driver);
        usersListPage = new UsersListPage(driver);
        logoutUserElements = new LogoutUserElements(driver);
        modifyUserPage = new ModifyUserPage(driver);
        toastMessages = new ToastMessages(driver);

        WaitUtils.waitForPageLoadComplete(driver, 5);

    }

}
