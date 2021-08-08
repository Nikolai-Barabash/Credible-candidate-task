package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

public class SignUpPage {

    private WebDriver driver;
    public static final String MY_FIRST_NAME = "Mikalai";
    public static final String DOMAIN_NAME = "@credible.com";

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SignUpPage addEmailID() {
        emailField.sendKeys(generateEmailId());
        return this;
    }

    public SignUpPage addPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    private String generateEmailId() {
        LocalDateTime currentTime = LocalDateTime.now();
        String timeStamp = new SimpleDateFormat("yyyyMMdd.HH.mm.ss").format(Calendar.getInstance().getTime());
        return  MY_FIRST_NAME + currentTime.getMonth() + currentTime.getDayOfMonth() + timeStamp + DOMAIN_NAME;
        }
}
