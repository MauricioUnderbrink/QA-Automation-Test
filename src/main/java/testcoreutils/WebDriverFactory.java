package testcoreutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private WebDriver driver;

    public WebDriverFactory(WebDriver driver){
        this.driver = driver;
    }

    /**
     * This method returns the WebDriver instance based on the browser type send in the parameter
     * @param browser The desired browser to use for the test
     * @return WebDriver
     */
    public static WebDriver createDriver(String browser){

        WebDriver driver;
        switch(browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;

    }






}
