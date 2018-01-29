package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TalentPage {

    public WebDriver driver;

    private By clickOnNew= By.xpath("//a[@class='btn btn-default btn-outline mr']");
    private By categoryclick= By.xpath("//div[@name='category']//i[@class='caret pull-right']");
    private By categoryMusic= By.xpath("//*[@class='ui-select-choices ui-select-choices-content ui-select-dropdown dropdown-menu ng-scope']/li//span[@class='ui-select-choices-row-inner' and text()='Music']");
    private By clickOnNext= By.xpath("//button[@class='btn btn-primary ng-binding']");
    private By typeFirstName= By.xpath("//input[@name='firstName']");



    public TalentPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickOnNew(){

        driver.findElement(clickOnNew).click();
    }

    public void clickOnCategory(){

        driver.findElement(categoryclick).click();
    }
    public void clickOnMusic(){

        driver.findElement(categoryMusic).click();
    }
    public void clickOnButton(){

        driver.findElement(clickOnNext).click();
    }
    public void typeName(String firstName){
        driver.findElement(typeFirstName).sendKeys(firstName);
   }

}
