package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcoreutils.WaitUtils;

public class ModifyUserPage {

private WebDriver driver;

    public ModifyUserPage(WebDriver driver) {
        this.driver = driver;
    }

    private By modifyUserMainPageWindowLocator = By.className("v-navigation-drawer__content");

    private By modifyUserPageTitleLocator = By.xpath("//div[@class='v-navigation-drawer__content']//div[contains(text(), 'Modify User')]");

    private By modifyAdminCheckBoxLocator = By.id("checkbox-modifyuser-admin");

    private By modifyFirstNameTextFieldLocator = By.id("textfield-modifyuser-firstname");

    private By modifyLastNameTextFieldLocator = By.id("textfield-modifyuser-lastname");

    private By modifyEmailTextFieldLocator = By.id("textfield-adduser-email");

    private By modifyPhoneNumberTextLocator = By.xpath("//input[@placeholder='Enter Mobile Number']");

    private By modifyNoteTextFieldLocator = By.id("textfield-modifyuser-notes");

    private By modifyResetPasswordButtonLocator = By.xpath("//span[normalize-space()='Reset Password']");

    private By modifySuspendedButtonLocator = By.cssSelector(
            ".v-btn.v-theme--light.text-primary.v-btn--density-default.v-btn--size-small.v-btn--variant-tonal.my-1.w-100");

    private By modifyDeleteButtonLocator = By.xpath("//span[normalize-space()='Delete']");
    private By modifySaveButtonLocator = By.xpath("//span[normalize-space()='Save']");

    private By modifyCancelButtonLocator = By.id("button-modifyuser-cancel");

    private By modifyClosePageLocator = By.cssSelector("button[class='v-btn v-btn--icon v-theme--light text-default v-btn--density-default v-btn--variant-tonal rounded'] span[class='v-btn__content'] svg");



    public WebElement getModifyUserMainPageWindowElement() {
        return WaitUtils.waitForPresenceOfElementByLocator(driver, modifyUserMainPageWindowLocator, 10);
    }


    public WebElement getModifyUserPageTitleElement() {
        return WaitUtils.waitForPresenceOfElementByLocator(driver, modifyUserPageTitleLocator, 10);
    }

    public String getModifyUserPageTitleText(){
        return getModifyUserPageTitleElement().getText();
    }

    public WebElement getModifyAdminCheckboxElement(){
       return WaitUtils.waitForPresenceOfElementByLocator(driver, modifyAdminCheckBoxLocator,5);
    }

    public void clickAdminCheckbox(){
        getModifyAdminCheckboxElement().click();
    }

    public WebElement getModifyFirstNameTextFieldElement() {
        return driver.findElement(modifyFirstNameTextFieldLocator);
    }

    public void enterModifyFirstName(String firstName) {
        getModifyFirstNameTextFieldElement().sendKeys(firstName);
    }

    public WebElement getModifyLastNameTextFieldElement(){
        return driver.findElement(modifyLastNameTextFieldLocator);
    }

    public void enterModifyLastName(String lastName){
        getModifyLastNameTextFieldElement().sendKeys(lastName);
    }

    public WebElement getModifyEmailTextFieldElement(){
        return driver.findElement(modifyEmailTextFieldLocator);
    }

    public void enterModifyEmail(String email){
        getModifyEmailTextFieldElement().sendKeys(email);
    }

    public WebElement getModifyPhoneNumberTextElement(){
        return driver.findElement(modifyPhoneNumberTextLocator);
    }

    public void enterModifyPhoneNumber(String phoneNumber){
        getModifyPhoneNumberTextElement().sendKeys(phoneNumber);
    }

    public WebElement getModifyNoteTextFieldElement(){
        return driver.findElement(modifyNoteTextFieldLocator);
    }

    public void enterModifyNotes(String notes){
        getModifyNoteTextFieldElement().sendKeys(notes);
    }

    public WebElement getModifySaveButtonElement(){
        return driver.findElement(modifySaveButtonLocator);
    }

    public void clickModifySaveButton(){
        getModifySaveButtonElement().click();
    }

    public WebElement getModifyCancelButtonElement(){
        return driver.findElement(modifyCancelButtonLocator);
    }

    public void clickModifyCancelButton(){
        getModifyCancelButtonElement().click();
    }

    public WebElement getModifyClosePageElement(){

        return driver.findElement(modifyClosePageLocator);
    }

    public void clickModifyClosePageIcon(){
        getModifyClosePageElement().click();
    }




}
