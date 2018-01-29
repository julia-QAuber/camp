package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyFirstLogin {

    WebDriver driver;

    @Test(dataProvider="myappData")
    public void loginToMyApp(String email, String password) throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

        driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary mt-lg']")).click();

        Thread.sleep(5000);

        //System.out.println(driver.getTitle());

        Assert.assertTrue(driver.getTitle().contains("Talents"),"User can not login-Invalid");

        System.out.println("Page Title- User can login");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @DataProvider(name="myappData")
    public Object[][] passData()
    {

    Object[][] data=new Object[3][2];
// valid email invalid password
    data[0][0]="jozifop@amail.club";

    data[0][1]="qwerty";

// valid email valid password
    data[1][0]="jozifop@amail.club";

    data[1][1]="qwerty123";

// invalid email invalid password
    data[2][0]="jozifop@amail.club1";

    data[2][1]="qwerty1234";

    return data;
    }


}
