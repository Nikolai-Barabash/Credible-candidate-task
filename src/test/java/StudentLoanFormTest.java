import core.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.StudentLoanPage;

import java.util.concurrent.TimeUnit;

public class StudentLoanFormTest {

private WebDriver driver;

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
public static final String INCOME_TYPE = "Salary";
public static final String ANNUAL_SALARY = "65000";
public static final String PREVIOUS_INCOME = "65000";
public static final String LOAN_AMOUNT = "42000";
public static final String PASSWORD = "Passw0rd";

    @BeforeClass
    public void setUp() {
        driver = Driver.getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tiersDown() {
        Driver.closeInstance();
    }

    @Test
    public void testStudentLoanForm() {
        driver.get("https://www.credible.com/?vt_disabled=true");
        StudentLoanPage studentLoanPage = new StudentLoanPage(driver);
        studentLoanPage.selectStudentLoanProduct();
        studentLoanPage.goToForm();
        studentLoanPage.chooseRole();
        studentLoanPage.addStudentFirstName(STUDENT_FIRST_NAME);
        studentLoanPage.addStudentLastName(STUDENT_LAST_NAME);
        studentLoanPage.addStudentDob(STUDENT_DOB);
        studentLoanPage.addPhoneNumber(PHONE_NUMBER);
        studentLoanPage.addAddress(ADDRESS, UNIT);
        studentLoanPage.chooseCitizenshipStatus(US_CITIZENSHIP);
        studentLoanPage.addCollege(COLLEGE_NAME);
        studentLoanPage.chooseCollegeDegree(COLLEGE_DEGREE);
        studentLoanPage.addExpectedGraduationDate(GRADUATION_DATE);
        studentLoanPage.addMonthlyHousingPayment(HOUSING_PAYMENT);
        studentLoanPage.chooseEmploymentStatus();
        studentLoanPage.addEmploymentIncome(INCOME_TYPE, ANNUAL_SALARY);
        studentLoanPage.addPreviousEmploymentIncome(PREVIOUS_INCOME);
        studentLoanPage.addCurrentEnrollmentStatus();
        studentLoanPage.chooseYearOfStudy();
        studentLoanPage.chooseSchoolTerm();
        studentLoanPage.addLoanAmount(LOAN_AMOUNT);
        studentLoanPage.addEmailID();
        studentLoanPage.addPassword(PASSWORD);
    }
}
