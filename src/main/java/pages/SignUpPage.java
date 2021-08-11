package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

public class SignUpPage {

    private WebDriver driver;
    private WebDriverWait wait;
    public static final String MY_FIRST_NAME = "Mikalai";
    public static final String DOMAIN_NAME = "@credible.com";
    private By controlElement = By.xpath("//div[@data-test-id='Back']/../../..");
    public static final int TIMEOUT = 5;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    public SignUpPage addEmailID() {
        waitForAnimation();
        wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailField.clear();
        emailField.sendKeys(generateEmailId());
        return this;
    }

    public SignUpPage addPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    private String generateEmailId() {
        LocalDateTime currentTime = LocalDateTime.now();
        String timeStamp = new SimpleDateFormat("yyyyMMdd.HH.mm.ss").format(Calendar.getInstance().getTime());
        return  MY_FIRST_NAME + currentTime.getMonth() + currentTime.getDayOfMonth() + timeStamp + DOMAIN_NAME;
        }

    public void waitForAnimation() {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                if (driver.findElement(controlElement).getAttribute("class").isEmpty()) {
                    return Boolean.TRUE;
                }
                return null;
            }
        });
    }
}
