package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentLoanFormPage {

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

    @FindBy(xpath = "(//div[@data-test-id='search-results']/ul/li/div/span)[1]")
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

    public StudentLoanFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public StudentLoanFormPage chooseRole() {
        studentRoleButton.click();
        return this;
    }

    public StudentLoanFormPage addStudentName(String firstName, String lastName) {
        wait.until(ExpectedConditions.elementToBeClickable(studentFirstNameField));
        studentFirstNameField.sendKeys(firstName);
        studentLastNameField.sendKeys(lastName);
        return continueToNextStep();
    }

    public StudentLoanFormPage continueToNextStep() {
        continueButton.click();
        return this;
    }

    public StudentLoanFormPage addStudentDob(String dob) {
        studentDobField.sendKeys(dob);
        return continueToNextStep();
    }

    public StudentLoanFormPage addPhoneNumber(String phoneNumber) {
        studentPhoneNumberField.sendKeys(phoneNumber);
        return continueToNextStep();
    }

    public StudentLoanFormPage addAddress(String address, String unitNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(addressField));
        addressField.sendKeys(address);
        wait.until(ExpectedConditions.elementToBeClickable(addressOption));
        addressOption.click();
        addressUnitField.sendKeys(unitNumber);
        return continueToNextStep();
    }

    public StudentLoanFormPage chooseCitizenshipStatus(boolean citizenship) {
        if (citizenship) {
            wait.until(ExpectedConditions.elementToBeClickable(confirmUsCitizenshipButton));
            confirmUsCitizenshipButton.click();
        }
        return this;
    }

    public StudentLoanFormPage addCollege(String collegeName) {
        //wait.until(ExpectedConditions.elementToBeClickable(collegeNameField));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        collegeNameField.sendKeys(collegeName);
        wait.until(ExpectedConditions.elementToBeClickable(collegeSearchResult));
        collegeSearchResult.click();
        return continueToNextStep();
    }

    public StudentLoanFormPage chooseCollegeDegree(String degree) {
        wait.until(ExpectedConditions.elementToBeClickable(aimedCollegeDegree));
        aimedCollegeDegree.click();
        return this;
    }

    public StudentLoanFormPage addExpectedGraduationDate(String graduationDate) {
        expectedGraduationDateField.sendKeys(graduationDate);
        return continueToNextStep();
    }

    public StudentLoanFormPage addMonthlyHousingPayment(String housingPayment) {
        wait.until(ExpectedConditions.elementToBeClickable(monthlyHousingPaymentField));
        monthlyHousingPaymentField.sendKeys(housingPayment);
        return continueToNextStep();
    }

    public StudentLoanFormPage chooseEmploymentStatus() {
        wait.until(ExpectedConditions.elementToBeClickable(employmentStatusButton));
        employmentStatusButton.click();
        return this;
    }

    public StudentLoanFormPage addEmploymentIncome(String incomeType, String annualSalary) {
        Select selectIncome = new Select(incomeTypeDropDown);
        selectIncome.selectByValue(incomeType);
        annualSalaryField.sendKeys(annualSalary);
        return continueToNextStep();
    }

//    public StudentLoanFormPage addPreviousEmploymentIncome(String income) {
//        wait.until(ExpectedConditions.elementToBeClickable(previousIncomeField));
//        previousIncomeField.sendKeys(income);
//        return continueToNextStep();
//    }

    public StudentLoanFormPage addCurrentEnrollmentStatus() {
        currentEnrollmentStatusButton.click();
        return this;
    }

    public StudentLoanFormPage chooseYearOfStudy() {
        currentYearOfStudyButton.click();
        return this;
    }

    public StudentLoanFormPage chooseSchoolTerm() {
        schoolTermButton.click();
        return this;
    }

    public StudentLoanFormPage addLoanAmount(String amount) {
        loanAmountField.sendKeys(amount);
        return this;
    }
}
