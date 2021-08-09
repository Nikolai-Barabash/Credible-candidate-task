import core.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SignUpPage;
import pages.StudentLoanFormPage;

public class StudentLoanFormTest {

    private WebDriver driver;
    private StudentLoanFormPage studentLoanFoamPage;
    private MainPage mainPage;
    private SignUpPage signUpPage;

    public static final int TIMEOUT = 5;

    public static final String STUDENT_FIRST_NAME = "Great";
    public static final String STUDENT_LAST_NAME = "CredibleProd";
    public static final String STUDENT_DOB = "08/08/2000";
    public static final String PHONE_NUMBER = "9803334422";
    public static final String ADDRESS = "6000 Old heartwood way, Matthews, NC, USA";
    public static final String UNIT = "460";
    public static final boolean US_CITIZENSHIP = true;
    public static final String COLLEGE_NAME = "Boise State University";
    public static final String COLLEGE_DEGREE = "Bachelor's";
    public static final String GRADUATION_DATE = "07/2025";
    public static final String HOUSING_PAYMENT = "800";
    public static final String INCOME_TYPE = "salary";
    public static final String ANNUAL_SALARY = "65000";
    public static final String LOAN_AMOUNT = "42000";
    public static final String PASSWORD = "Passw0rd";

    @BeforeClass
    public void setUp() {
        driver = Driver.getInstance();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterScenario() {
        Driver.closeInstance();
    }

    @Test
    public void testStudentLoanForm() {
        driver.get("https://www.credible.com/?vt_disabled=true");

        mainPage = new MainPage(driver);
        mainPage.selectStudentLoanProduct();
        studentLoanFoamPage = mainPage.goToStudentLoanForm();
        studentLoanFoamPage.chooseRole()
                .addStudentName(STUDENT_FIRST_NAME, STUDENT_LAST_NAME)
                .addStudentDob(STUDENT_DOB)
                .addPhoneNumber(PHONE_NUMBER)
                .addAddress(ADDRESS, UNIT)
                .chooseCitizenshipStatus(US_CITIZENSHIP)
                .addCollege(COLLEGE_NAME)
                .chooseCollegeDegree(COLLEGE_DEGREE)
                .addExpectedGraduationDate(GRADUATION_DATE)
                .addMonthlyHousingPayment(HOUSING_PAYMENT)
                .chooseEmploymentStatus()
                .addEmploymentIncome(INCOME_TYPE, ANNUAL_SALARY)
                .continueToNextStep()
                .continueToNextStep()
                .addCurrentEnrollmentStatus()
                .chooseYearOfStudy()
                .chooseSchoolTerm()
                .addLoanAmount(LOAN_AMOUNT);

        signUpPage = new SignUpPage(driver);
        signUpPage.addEmailID()
                .addPassword(PASSWORD);
    }
}
