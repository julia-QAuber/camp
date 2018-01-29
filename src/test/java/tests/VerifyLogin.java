package tests;


import DataProvider.Constant;
import DataProvider.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class VerifyLogin {
    public WebDriver driver;
    private LoginPage objLogin;
    WebDriverWait wait;




    @BeforeTest
    public void verifyvalidLogin() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(Constant.myURL);
       wait= new WebDriverWait(driver,10);
    }
    @DataProvider
    public Object[][] thisTestData(ITestNGMethod context) throws Exception{

        String sMethodName = context.getMethodName();
        System.out.println(sMethodName);



        // TODO fetch excel Sheet by Test Class Name

        // Setting the Excel file path and Sheet
        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"login");
        // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
        int iTestCaseRow = ExcelUtils.getRowContains(sMethodName, 0);
        // Getting the number of cells for the caller test method
        int iTotalCells =ExcelUtils.getTotalCells(iTestCaseRow);
        // Get the cell values
        Object[][] testObjArray = ExcelUtils.getTableArray(Constant.Path_TestData + Constant.File_TestData,"login",iTestCaseRow,iTotalCells);

        return (testObjArray);



    }


        @Test(dataProvider = "thisTestData", priority = 0)
        public void test_Home_Page_Apper_Correct(String username, String password){


            objLogin = new LoginPage(driver);

            objLogin.typeUserName(username);
            objLogin.typePassword(password);
        objLogin.clickOnLoginButton();

       // String loginPageTitle = objLogin.getLoginTitle();

       // Assert.assertTrue(loginPageTitle.toLowerCase().contains("SIGN IN TO CONTINUE"));*/
          wait.until(ExpectedConditions.titleIs("ProMytheUs - Talents"));
        Assert.assertEquals(driver.getTitle(),"ProMytheUs - Talents");
        System.out.println("Page Title- User can login");

    }
//
//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }



}


