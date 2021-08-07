package pages;

import org.apache.tools.ant.types.resources.comparators.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class StudentLoanPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div/p[text()='Student']/..")
    private WebElement studentLoanButton;

    @FindBy(xpath = "//a[@href='/private-student-loans/prequal/role']")
    private WebElement getStartedButton;

    @FindBy(xpath = "//span[text()='Student']")
    private WebElement studentRoleButton;

    @FindBy(xpath = "//input[@name='studentFirstName']")
    private WebElement studentFirstNameField;

    @FindBy(xpath = "//input[@name='studentLastName']")
    private WebElement studentLastNameField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@name='studentDob']")
    private WebElement studentDobField;

    @FindBy(xpath = "//input[@name='studentPhone']")
    private WebElement studentPhoneNumberField;

    @FindBy(xpath = "//input[@name='inschoolPrequalForm.studentAddress.fullAddress']")
    private WebElement addressField;

    @FindBy(xpath = "//ul[@role='listbox']/li")
    private WebElement addressOption;

    @FindBy(xpath = "//input[@name='studentAddress.unit']")
    private WebElement addressUnitField;

    @FindBy(xpath = "//input[@name='inschoolPrequalForm.studentCitizenshipStatus-radio']/parent::div")
    private WebElement confirmUsCitizenshipButton;

    @FindBy(xpath = "//input[@name='studentEducation.name']")
    private WebElement collegeNameField;

    @FindBy(xpath = "(//ul//li)[1]")
    private WebElement collegeSearchResult;

    @FindBy(xpath = "//*[text()=\"Bachelor's\"]")
    private WebElement aimedCollegeDegree;

    @FindBy(xpath = "//input[@name='studentCompletionDate']")
    private WebElement expectedGraduationDateField;

    @FindBy(xpath = "//input[@name='studentHousingPayment']")
    private WebElement monthlyHousingPaymentField;

    @FindBy(xpath = "//input[@value='employed_full_time']/following-sibling::div")
    private WebElement employmentStatusButton;

    @FindBy(xpath = "//select[@name='studentEmploymentIncomeType']")
    private WebElement incomeTypeDropDown;

    @FindBy(xpath = "//input[@id='studentIncomeYearly']")
    private WebElement annualSalaryField;

    @FindBy(xpath = "//input[@id='studentPreviousEmploymentIncome']")
    private WebElement previousIncomeField;

    @FindBy(xpath = "//span[text()='Full-time']")
    private WebElement currentEnrollmentStatusButton;

    @FindBy(xpath = "//span[text()='1st year']")
    private WebElement currentYearOfStudyButton;

    @FindBy(xpath = "//span[text()='Fall 2021']")
    private WebElement schoolTermButton;

    @FindBy(xpath = "//input[@id='studentRequestedLoanAmount']")
    private WebElement loanAmountField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    public StudentLoanPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void selectStudentLoanProduct() {
        studentLoanButton.click();
    }

    public void goToForm() {
        getStartedButton.click();
    }

    public void chooseRole() {
        studentRoleButton.click();
    }

    public void addStudentFirstName(String firstName) {
        wait.until(ExpectedConditions.elementToBeClickable(studentFirstNameField));
        studentFirstNameField.sendKeys(firstName);
    }

    public void addStudentLastName(String lastName) {
        studentLastNameField.sendKeys(lastName);
        continueToNextStep();
    }

    public void continueToNextStep() {
        continueButton.click();
    }

    public void addStudentDob(String dob) {
        studentDobField.sendKeys(dob);
        continueToNextStep();
    }

    public void addPhoneNumber(String phoneNumber) {
        studentPhoneNumberField.sendKeys(phoneNumber);
        continueToNextStep();
    }

    public void addAddress(String address, String unitNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(addressField));
        addressField.sendKeys(address);
        wait.until(ExpectedConditions.elementToBeClickable(addressOption));
        addressOption.click();
        addressUnitField.sendKeys(unitNumber);
        continueToNextStep();
    }

    public void chooseCitizenshipStatus(boolean citizenship) {
        if (citizenship) {
            wait.until(ExpectedConditions.elementToBeClickable(confirmUsCitizenshipButton));
            confirmUsCitizenshipButton.click();
        }
    }

    public void addCollege(String collegeName) {
        collegeNameField.sendKeys(collegeName);
        wait.until(ExpectedConditions.elementToBeClickable(collegeSearchResult));
        collegeSearchResult.click();
        continueToNextStep();
    }

    public void chooseCollegeDegree(String degree) {
        aimedCollegeDegree.click();
    }

    public void addExpectedGraduationDate(String graduationDate) {
        expectedGraduationDateField.sendKeys(graduationDate);
        continueToNextStep();
    }

    public void addMonthlyHousingPayment(String housingPayment) {

        wait.until(ExpectedConditions.visibilityOf(monthlyHousingPaymentField));
        monthlyHousingPaymentField.sendKeys(housingPayment);
        continueToNextStep();
    }

    public void chooseEmploymentStatus() {
        wait.until(ExpectedConditions.elementToBeClickable(employmentStatusButton));
        employmentStatusButton.click();
    }

    public void addEmploymentIncome(String incomeType, String annualSalary) {
        Select selectIncome = new Select(incomeTypeDropDown);
        selectIncome.selectByValue(incomeType);
        annualSalaryField.sendKeys(annualSalary);
        continueToNextStep();
    }

    public void addPreviousEmploymentIncome(String income) {
        wait.until(ExpectedConditions.elementToBeClickable(previousIncomeField));
        previousIncomeField.sendKeys(income);
        continueToNextStep();
    }

    public void addCurrentEnrollmentStatus() {
        currentEnrollmentStatusButton.click();
    }

    public void chooseYearOfStudy() {
        currentYearOfStudyButton.click();
    }

    public void chooseSchoolTerm() {
        schoolTermButton.click();
    }

    public void addLoanAmount(String amount) {
        loanAmountField.sendKeys();
    }

    public void addEmailID() {
        emailField.sendKeys(generateEmilId());
    }

    public void addPassword(String password) {
        passwordField.sendKeys(password);
    }

    public String generateEmilId(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String timeStamp = dateFormat.format(date);
        String emailId = "Mikalai" + timeStamp + "@credible.com";
        return emailId;
    }
}
