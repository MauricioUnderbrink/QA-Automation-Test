package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcoreutils.WaitUtils;

public class AddUserPage {

   private WebDriver driver;
   public AddUserPage(WebDriver driver) {
      this.driver = driver;
   }

   private By addUserMainPageWindowLocator = By.className("v-navigation-drawer__content");

   private By addUserPageTitleLocator = By.xpath("//div[@class='v-navigation-drawer__content']//div[contains(text(), 'Add User')]");

   private By adminCheckBoxElement = By.id("checkbox-adduser-admin");

   private By sendEmailInviteCheckboxLocator = By.xpath("//input[@aria-label='Send email invite']");

   private By firstNameTextFieldLocator = By.id("textfield-adduser-firstname");

   private By firstNameTextFieldErrorMessage = By.cssSelector("div[id='textfield-adduser-firstname-messages'] div[class='v-messages__message']");

   private By lastNameTextFieldLocator = By.id("textfield-adduser-lastname");

   private By lastNameTextFieldErrorMessage = By.cssSelector("div[id='textfield-adduser-lastname-messages'] div[class='v-messages__message']");

   private By emailTextFieldLocator = By.id("textfield-adduser-email");

   private By emailTextFieldErrorMessage = By.cssSelector("div[id='textfield-adduser-email-messages'] div[class='v-messages__message']");

   private By phoneNumberTextLocator = By.cssSelector(".vti__input vti__phone");

   private By noteTextFieldLocator = By.id("textfield-adduser-notes");

   private By saveButtonLocator = By.id("button-adduser-submit");

   private By cancelButtonLocator = By.xpath("//span[normalize-space()='Cancel']");

   private By closePageLocator = By.cssSelector("button[id='btn-closeAddUser'] span[class='v-btn__content'] svg");

   public WebElement getAddUserMainPageWindowElement() {
      return WaitUtils.waitForPresenceOfElementByLocator(driver, addUserMainPageWindowLocator, 10);
   }


   public WebElement getAddUserPageTitleElement() {
      return WaitUtils.waitForPresenceOfElementByLocator(driver, addUserPageTitleLocator, 10);
   }

   public String getAddUserPageTitleText(){
      return getAddUserPageTitleElement().getText();
   }

   public WebElement getAdminCheckboxElement(){
      return driver.findElement(adminCheckBoxElement);
   }

   public void clickAdminCheckbox(){
      getAdminCheckboxElement().click();
   }

   public WebElement getSendEmailInviteCheckboxElement(){
      return driver.findElement(sendEmailInviteCheckboxLocator);
   }

   public void clickSendEmailInviteCheckbox(){
      getSendEmailInviteCheckboxElement().click();
   }

   public WebElement getFirstNameTextFieldElement() {
      return driver.findElement(firstNameTextFieldLocator);
   }

   public void enterFirstName(String firstName) {
         getFirstNameTextFieldElement().sendKeys(firstName);
   }

   public String getFirstNameTextFieldErrorMessage(){
      WaitUtils.waitForPresenceOfElementByLocator(driver,firstNameTextFieldErrorMessage,10 );
      return driver.findElement(firstNameTextFieldErrorMessage).getText();
   }

   public WebElement getLastNameTextFieldElement(){
      return driver.findElement(lastNameTextFieldLocator);
   }

   public void enterLastName(String lastName){
      getLastNameTextFieldElement().sendKeys(lastName);
   }

   public String getLastNameTextFieldErrorMessage(){
      WaitUtils.waitForPresenceOfElementByLocator(driver,lastNameTextFieldErrorMessage,10 );
      return driver.findElement(lastNameTextFieldErrorMessage).getText();
   }
   public WebElement getEmailTextFieldElement(){
      return driver.findElement(emailTextFieldLocator);
   }

   public void enterEmail(String email){
      getEmailTextFieldElement().sendKeys(email);
   }

   public String getEmailTextFieldErrorMessage(){
      WaitUtils.waitForPresenceOfElementByLocator(driver,emailTextFieldErrorMessage,10 );
      return driver.findElement(emailTextFieldErrorMessage).getText();
   }
   public WebElement getPhoneNumberTextElement(){
      return driver.findElement(phoneNumberTextLocator);
   }

   public void enterPhoneNumber(String phoneNumber){
      getPhoneNumberTextElement().sendKeys(phoneNumber);
   }

   public WebElement getNoteTextFieldElement(){
      return driver.findElement(noteTextFieldLocator);
   }

   public void enterNotes(String notes){
      getNoteTextFieldElement().sendKeys(notes);
   }

   public WebElement getSaveButtonElement(){
     return driver.findElement(saveButtonLocator);
   }

   public void clickSaveButton(){
      getSaveButtonElement().click();
   }

   public WebElement getCancelButtonElement(){
      return driver.findElement(cancelButtonLocator);
   }

   public void clickCancelButton(){
      getCancelButtonElement().click();
   }

   public WebElement getClosePageElement(){

      return driver.findElement(closePageLocator);
   }

   public void clickClosePageIcon(){
      getClosePageElement().click();
   }


}
