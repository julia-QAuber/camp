
        package DataProvider;



        import org.apache.poi.xssf.usermodel.XSSFCell;
        import org.apache.poi.xssf.usermodel.XSSFRow;
        import org.apache.poi.xssf.usermodel.XSSFSheet;
        import org.apache.poi.xssf.usermodel.XSSFWorkbook;

        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;

public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

    public static void setExcelFile(String Path,String SheetName) throws Exception {

        try {

            // Open the Excel file

            FileInputStream ExcelFile = new FileInputStream(Path);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

        } catch (Exception e){

            throw (e);

        }

    }

    public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow, int TotalCols)    throws Exception

    {

        String[][] tabArray = null;

        try{

            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int startCol = 1;

            int ci=0,cj=0;

            int totalRows = 1;

            int totalCols = TotalCols;

            tabArray=new String[totalRows][totalCols];

            for (int j=startCol;j<=totalCols;j++, cj++)

            {

                tabArray[ci][cj]=getCellData(iTestCaseRow,j);

                System.out.println("TabArray values:" + tabArray[ci][cj]);

            }

        }

        catch (FileNotFoundException e)

        {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        catch (IOException e)

        {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        return(tabArray);

    }

    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    public static String getCellData(int RowNum, int ColNum) throws Exception{

        try{




            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            String CellData = Cell.getStringCellValue();

            System.out.println("Reading " +RowNum+" - " + ColNum + " value= "+CellData);

            return CellData;

        }catch (IllegalStateException e){

            if (e.getMessage().contains("Cannot get a STRING value from a NUMERIC cell")) {

                double CellDataDbl = Cell.getNumericCellValue();
                String CellData;
                boolean isInt=false;

                //SET COLUMNS TO BE CONVERTED TO INTEGER
                int[] IntegerColumns = {4,10};

                for (int n: IntegerColumns){
                    if (n==ColNum){isInt=true;}
                }

                if (isInt){
                    int CellDataInt = (int) CellDataDbl;
                    CellData = String.valueOf(CellDataInt);
                }
                else {CellData = String.valueOf(CellDataDbl);}


                return CellData;
            }

            System.out.println(e);

            return"";

        }
        catch (Exception e) {

            System.out.println(e);

            return"";

        }

    }

    public static String getTestCaseName(String sTestCase)throws Exception{

        String value = sTestCase;

        try{

            int posi = value.indexOf("@");

            value = value.substring(0, posi);

            posi = value.lastIndexOf(".");

            value = value.substring(posi + 1);

            return value;

        }catch (Exception e){

            throw (e);

        }

    }

    public static int getRowContains(String sTestCaseName, int colNum) throws Exception{

        int i;

        try {

            int rowCount = getRowUsed();

            for ( i=0 ; i<rowCount; i++){

                if  (getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){

                    break;

                }

            }

            return i;

        }catch (Exception e){

            throw(e);

        }

    }

    public static int getRowUsed() throws Exception {

        try{

            int RowCount = ExcelWSheet.getLastRowNum();

            return RowCount;

        }catch (Exception e){

            System.out.println(e.getMessage());

            throw (e);

        }

    }

    public static int getTotalCells(int cRow) throws Exception {

        try{

            int cellsNum=0;
            int i=1;
            String str;


            do  {

                str = ExcelUtils.getCellData(cRow, i++);
                cellsNum++;


            }while (str!=null && !str.equals(""));

            return cellsNum-1;

        }catch (Exception e){

            System.out.println("EXCEPTION: "+e.getMessage());

            throw (e);

        }

    }

    public static String[] getValidCredentials () throws Exception {

        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"login");
        String[] c = new String[2];
        c[0] = getCellData(1,1);
        c[1] = getCellData(1,2);


        //{getCellData(1,1),getCellData(1,2)};

        return c;
    }





    //This method is to write in the Excel cell, Row num and Col num are the parameters

    public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

        try{

            Row  = ExcelWSheet.getRow(RowNum);

            Cell = Row.getCell(ColNum);

            if (Cell == null) {

                Cell = Row.createCell(ColNum);

                Cell.setCellValue(Result);

            } else {

                Cell.setCellValue(Result);

            }

            // Constant variables Test Data path and Test Data file name

            FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

            ExcelWBook.write(fileOut);

            fileOut.flush();

            fileOut.close();

        }catch(Exception e){

            throw (e);

        }

    }

}
