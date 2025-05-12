package page_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcoreutils.SeleniumTestUtils;
import testcoreutils.WaitUtils;

public class UsersListPage {

    private WebDriver driver;

    public UsersListPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchFieldLocator = By.xpath("//input[@id=//label[normalize-space()='Search']/@for]");

    private By selectUserStatusLocator = By.xpath("//div[@data-testid='dropdown-select-user-status']//div[@class='v-field__input']");

    private By selectChannelConnectionStatusLocator = By.xpath("//div[@data-testid='dropdown-select-channel-connection-status']//div[@class='v-field__input']");

    private By clearFilterButtonLocator = By.xpath("//span[normalize-space()='Clear Filters']");

    private By addUserButtonLocator = By.xpath("//span[normalize-space()='Add User']");

    private By listTableLocator = By.id("virtualTable");

    private By firstRecordLocator = By.xpath(".//tbody/tr[2]");

    private By firstRecordNameLocator = By.xpath(".//tbody/tr[2]/td[3]");
    private By nameButtonLocator = By.xpath("//button[@data-testid='user-name-in-list']");

    private By userEmailLocator = By.xpath(".//tbody/tr[2]/td[5]");



    public WebElement getSearchFieldElement(){
  return WaitUtils.waitForPresenceOfElementByLocator(driver, searchFieldLocator, 10);

}

public void enterSearchText(String searchText){
        WebElement searchField = getSearchFieldElement();
        searchField.click();
    searchField.sendKeys(searchText);
}

public WebElement getUserStatusDropdownElement(){
    return driver.findElement(selectUserStatusLocator);
}

public void searchByStatusOption(String status){
    SeleniumTestUtils.setDropdownByText(driver,getUserStatusDropdownElement(),status);
}

public WebElement getSelectChannelConnectionStatusElement(){
    return driver.findElement(selectChannelConnectionStatusLocator);
}

public void searchByChannelConnectionStatusByText(String chanelConnectionStatus){
    SeleniumTestUtils.setDropdownByText(driver, getSelectChannelConnectionStatusElement(),chanelConnectionStatus);
}

public WebElement getClearFilterButton(){
    return driver.findElement(clearFilterButtonLocator);
}

public void clickClearFilterButton(){
    if(getClearFilterButton().isEnabled()){
        getClearFilterButton().click();
    }else{
        System.out.println("There are no filter options selected");
    }
}

public WebElement getAddUserButtonElement(){

       return WaitUtils.waitForPresenceOfElementByLocator(driver, addUserButtonLocator, 10);

}

public void clickAddUserButton(){
    getAddUserButtonElement().click();
}

public WebElement getListTableElement(){
   return driver.findElement(listTableLocator);
}

public WebElement getFirstRecordElement(){
    return getListTableElement().findElement(firstRecordLocator);
}

public WebElement getNameButtonElement(){
    return getFirstRecordElement().findElement(nameButtonLocator);
}

public void clickNameButtonFromList(){
    getNameButtonElement().click();
}

public WebElement getFirstRecordNameElement(){
    return getListTableElement().findElement(firstRecordNameLocator);
}

public String getFirstRecordName(){
    return getFirstRecordNameElement().getText();
}

public WebElement getUserEmailElement(){
    return getListTableElement().findElement(userEmailLocator);
}

public String getUserEmail(){
    return getUserEmailElement().getText();
}

}
