package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyRegistration {

   WebDriver driver;

   public void RegisterToMyApp(){
       driver=new ChromeDriver();

       driver.manage().window().maximize();

       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

       driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");

       driver.findElement(By.xpath("//a[@class='btn btn-block btn-default']")).click();
   }



}
