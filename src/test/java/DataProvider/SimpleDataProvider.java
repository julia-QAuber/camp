package DataProvider;

public class SimpleDataProvider {

    Object [][] data;

    public Object[][] simpleData(){

        data = new String[1][2];

        data[0][0] = "Tom";
        data[0][1] = "Sing";

        return data;
    }
}
