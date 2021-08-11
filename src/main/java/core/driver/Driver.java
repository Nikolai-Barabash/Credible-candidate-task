package core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;

    public Driver() {
    }

    public static WebDriver getInstance() {

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeInstance() {
        driver.quit();
        driver = null;
    }
}



