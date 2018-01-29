package tests;


import DataProvider.Constant;
import DataProvider.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.RegistrationPage;


import java.util.concurrent.TimeUnit;

public class VerifyRegistration {
    WebDriver driver;
    RegistrationPage objRegistration;




    @BeforeTest
    public void verifyvalidRegistration() {
        driver = new ChromeDriver();
        objRegistration = new RegistrationPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Driver Set");

    }
    //@Parameters({"myURL","registfirstName","registlastName","registerEmail","registPhone","registPassword","registrePassword","registAdress","registCity","registState","registZip"})
    @DataProvider
    public Object[][] thisTestData(ITestNGMethod context) throws Exception {

        String sMethodName = context.getMethodName();
        System.out.println(sMethodName);

        // Setting the Excel file path and Sheet
        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "login");
        // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
        int iTestCaseRow = ExcelUtils.getRowContains(sMethodName, 0);
        System.out.println("Test rows "+iTestCaseRow);
        // Getting the number of cells for the caller test method
        int iTotalCells = ExcelUtils.getTotalCells(iTestCaseRow);
        // Get the cell values
        Object[][] testObjArray = ExcelUtils.getTableArray(Constant.Path_TestData + Constant.File_TestData, "login", iTestCaseRow, iTotalCells);

        return (testObjArray);
    }

    @Test (dataProvider = "thisTestData", priority = 0)
    public void test_Registration(String registfirstName, String registlastName, String registerEmail, String registPhone, String registPassword, String registrePassword,
                                  String registAdress, String registCity, String registState, String registZip){
        System.out.println("Getting URL");
        driver.get(Constant.myURL);
    objRegistration.clickOnRegister();
    objRegistration = new RegistrationPage(driver);
    objRegistration.typeFirstName(registfirstName);
    objRegistration.typeLastName(registlastName);
    objRegistration.typeEmail(registerEmail);
    objRegistration.typePhone(registPhone);
    objRegistration.typePassword(registPassword);
    objRegistration.typeRePassword(registrePassword);
    objRegistration.typeAdress(registAdress);
    objRegistration.typeCity(registCity);
    objRegistration.typeState(registState);
    objRegistration.typeZip(registZip);
    objRegistration.clickCreate();


    }

   // @Parameters({"username","password","myURL"})
   // @Test(priority = 0)
 //   public void test_Home_Page_Apper_Correct(String username, String password, String myURL){

//        driver.get(myURL);
//        objLogin = new LoginPage(driver);
//
//        objLogin.typeUserName(username);
//        objLogin.typePassword(password);
//        objLogin.clickOnLoginButton();
//
///*        String loginPageTitle = objLogin.getLoginTitle();
//
//        Assert.assertTrue(loginPageTitle.toLowerCase().contains("SIGN IN TO CONTINUE"));*/


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }








    }




