package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    @FindBy(xpath = "//div/p[text()='Student']/..")
    private WebElement studentLoanButton;

    @FindBy(xpath = "//a[@href='/private-student-loans/prequal/role']")
    private WebElement getStartedButton;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectStudentLoanProduct() {
        studentLoanButton.click();
    }

    public StudentLoanFormPage goToStudentLoanForm() {
        getStartedButton.click();
        return new StudentLoanFormPage(driver);
    }

}
