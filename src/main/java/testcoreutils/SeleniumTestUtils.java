package testcoreutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SeleniumTestUtils {

    /**
     * This method will return a list of available options for the dropdown
     *
     * @param driver  WebDriver
     * @param element WebElement
     * @return List of Options
     */
    public static List<String> getDropdownOptions(WebDriver driver, WebElement element) {
        List<String> options = new ArrayList<>();

        if (element != null && element.isEnabled()) {

            Select dropdownField = new Select(element);

            List<WebElement> optionsElements = dropdownField.getOptions();

            for (WebElement eachOptionElement : optionsElements) {

                options.add(eachOptionElement.getText());
            }
        } else {
            System.out.println("Dropdown element is null or not enabled");
        }
        return options;
    }

    /**
     * This method will set the dropdown field by text
     *
     * @param driver  WebDriver
     * @param element WebElement
     * @param text    provided text to set the dropdown
     */
    public static void setDropdownByText(WebDriver driver, WebElement element, String text) {

        if (element != null && element.isEnabled()) {

            Select dropdownField = new Select(element);

            List<WebElement> dropdownOptions = dropdownField.getOptions();
            boolean matchFound = false;

            for (WebElement eachDropdownOption : dropdownOptions) {
                String optionText = eachDropdownOption.getText();
                if (optionText.equals(text)) {
                    dropdownField.selectByVisibleText(text);
                    break;
                }
            }
            if (!matchFound) {
                System.out.println("No dropdown option matches the status: " + text);
            }
        } else {
            System.out.println("Dropdown element is null or not enabled");
        }
    }


    public static int generateRandomNumbers() {
        Random random = new Random();
        return 10000 + random.nextInt(90000);
    }

    public static String generateRandomEmail() {
        return "testemail" + generateRandomNumbers() + "@test.com";
    }

    public static String generateRandomName() {
        return "Mary" + generateRandomNumbers();
    }

    public static String generateRandomLastName() {
        return "James" + generateRandomNumbers();
    }

}
