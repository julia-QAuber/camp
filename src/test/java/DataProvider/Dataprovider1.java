package DataProvider;

import org.testng.ITestNGMethod;

public class Dataprovider1 {
    public Object[][] thisTestData(ITestNGMethod context) throws Exception {

        String sMethodName = context.getMethodName();
        System.out.println(sMethodName);


        // TODO fetch excel Sheet by Test Class Name

        // Setting the Excel file path and Sheet
        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "login");
        // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
        int iTestCaseRow = ExcelUtils.getRowContains(sMethodName, 0);
        // Getting the number of cells for the caller test method
        int iTotalCells = ExcelUtils.getTotalCells(iTestCaseRow);
        // Get the cell values
        Object[][] testObjArray = ExcelUtils.getTableArray(Constant.Path_TestData + Constant.File_TestData, "login", iTestCaseRow, iTotalCells);

        return (testObjArray);


    }
}