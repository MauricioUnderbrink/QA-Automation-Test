package test;

import base.BaseTest;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testUtils.LoginHelper;
import testcoreutils.CredentialReader;
import testcoreutils.SeleniumTestUtils;

public class UserValidationTest extends BaseTest {

    private LoginHelper loginHelper;

    private String adminFirstName;
    private String adminLastName;
    private String adminEmail;
    private String userFirstName;
    private String userLastName;
    private String userEmail;


    @BeforeClass
    public void setUp() {
        super.setUp("chrome");
        LoginHelper loginHelper = new LoginHelper(driver);
        loginHelper.loginUser("admin");
        mainSidebarPage.clickTheManageUsersMenu();

    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    /**
     * This test will test the required field and the required message
     */
    @Test(priority = 1)
    public void testRequiredFieldsForNewUser() {
        usersListPage.clickAddUserButton();
        addUserPage.clickAdminCheckbox();
        addUserPage.getFirstNameTextFieldElement().sendKeys("", Keys.TAB);
        String firstNameErrorMessage = addUserPage.getFirstNameTextFieldErrorMessage();
        String expectedMessage = "This field is required";
        Assert.assertEquals(firstNameErrorMessage, expectedMessage);
        addUserPage.getLastNameTextFieldElement().sendKeys("", Keys.TAB);
        String lastNameErrorMessage = addUserPage.getLastNameTextFieldErrorMessage();
        Assert.assertEquals(lastNameErrorMessage, expectedMessage);
        addUserPage.getEmailTextFieldElement().sendKeys("", Keys.TAB);
        String emailErrorMessage = addUserPage.getEmailTextFieldErrorMessage();
        Assert.assertEquals(emailErrorMessage, expectedMessage);
        addUserPage.clickCancelButton();
    }

    /**
     * This test covers the scenario where a new admin user is created successfully.
     */
    @Test(priority = 2)
    public void testCreatingAnAdminUser() {
        usersListPage.clickAddUserButton();
        addUserPage.clickAdminCheckbox();
        adminFirstName = SeleniumTestUtils.generateRandomName();
        addUserPage.enterFirstName(adminFirstName);
        adminLastName = SeleniumTestUtils.generateRandomLastName();
        addUserPage.enterLastName(adminLastName);
        adminEmail = SeleniumTestUtils.generateRandomEmail();
        addUserPage.enterEmail(adminEmail);
        addUserPage.enterNotes("Test Admin User");
        addUserPage.clickSaveButton();
        String successMessage = toastMessages.getToastMessageText();
        toastMessages.closeToastMessage();
        String expectedMessage = "User added successfully";
        Assert.assertEquals(successMessage, expectedMessage);
        usersListPage.enterSearchText(adminEmail);
        String actualAdminEmail = usersListPage.getUserEmail();
        Assert.assertEquals(actualAdminEmail, adminEmail);
        usersListPage.clickClearFilterButton();

    }

    /**
     * This test covers the scenario where a new user is created successfully.
     */
    @Test(priority = 3)
    public void testCreatingUser() {
        usersListPage.clickAddUserButton();
        userFirstName = SeleniumTestUtils.generateRandomName();
        addUserPage.enterFirstName(userFirstName);
        userLastName = SeleniumTestUtils.generateRandomLastName();
        addUserPage.enterLastName(userLastName);
        userEmail = SeleniumTestUtils.generateRandomEmail();
        addUserPage.enterEmail(userEmail);
        addUserPage.enterNotes("Test user");
        addUserPage.clickSaveButton();
        String successMessage = toastMessages.getToastMessageText();
        toastMessages.closeToastMessage();
        String expectedMessage = "User added successfully";
        Assert.assertEquals(successMessage, expectedMessage);
        usersListPage.enterSearchText(userEmail);
        String actualAdminEmail = usersListPage.getUserEmail();
        Assert.assertEquals(actualAdminEmail, userEmail);
        usersListPage.clickNameButtonFromList();
        Assert.assertFalse(modifyUserPage.getModifyAdminCheckboxElement().isSelected());
        modifyUserPage.clickModifyCancelButton();
        //usersListPage.clickClearFilterButton();
    }

    /**
     * This test covers the scenario where creating a duplicate user is not allowed.
     */
    @Test(priority = 4)
    public void testCreatingDuplicateUser() {
        usersListPage.clickAddUserButton();
        addUserPage.enterFirstName(userFirstName);
        addUserPage.enterLastName(userLastName);
        addUserPage.enterEmail(userEmail);
        addUserPage.enterNotes("Test duplicate user");
        toastMessages.closeToastMessage();
        addUserPage.clickSaveButton();
        String alertErrorMessage = toastMessages.getToastMessageText();
        String expectedErrorMessage = "Email is already in use";
        Assert.assertEquals(alertErrorMessage, expectedErrorMessage);
        toastMessages.closeToastMessage();
        addUserPage.clickCancelButton();

    }
    /**
     * This test covers the scenario where the logged-in admin is not be allowed to modify their own access.
     */
    @Test(priority = 5)
    public void testModifiyingAccessToTheSameLoggedInUser() {
        String username = CredentialReader.getUserName("admin");
        usersListPage.clickClearFilterButton();
        usersListPage.enterSearchText(username);
        usersListPage.clickNameButtonFromList();
        modifyUserPage.getModifyAdminCheckboxElement().click();
        toastMessages.closeToastMessage();
        modifyUserPage.clickModifySaveButton();
        String alertErrorMessage = toastMessages.getToastMessageText();
        String actualErrorMessage = "The user cannot update his/her own permissions.";
        Assert.assertEquals(alertErrorMessage, actualErrorMessage);
        toastMessages.closeToastMessage();
        addUserPage.clickCancelButton();

    }


}
