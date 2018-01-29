package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyNewTalent {

    WebDriver driver;

    @Test
    public void loginTalent( ){

     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");
     //login
     driver.findElement(By.xpath("//input[@name='email']")).sendKeys(data.email());
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(data.lastName());

        driver.findElement(By.id("address")).sendKeys(data.lastName());
        driver.findElement(By.xpath("//button[@class='btn btn-primary ng-binding']")).click();

        //--New Talent--Talent Traits
        List<WebElement> traits = driver.findElements(By.xpath("//input[contains(@name,'categoryTrait')]"));
        for (WebElement trait: traits) {

            trait.click();
            trait.sendKeys("8");}

        driver.findElement(By.xpath("//button[@class='btn btn-primary ng-binding']")).click();
        driver.findElement(By.xpath("//span[@class='ng-binding' and text()='Personality Traits']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary ng-binding']")).click();
        driver.findElement(By.xpath("//span[@class='ng-binding' and text()='Story']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary ng-binding']")).click();
        driver.findElement(By.xpath("//span[@class='ng-binding' and text()='Evidence']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary ng-binding']")).click();
        driver.findElement(By.xpath("//span[@class='ng-binding' and text()='Training']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary ng-binding']")).click();
        driver.findElement(By.xpath("//span[@class='ng-binding' and text()='Social Background']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary ng-binding']")).click();
        driver.findElement(By.xpath("//span[@class='ng-binding' and text()='Quick Tests']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary ng-binding']")).click();


    }

    }


