package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;

   private By registerbutton= By.xpath("//a[@class='btn btn-block btn-default']");
   private By registfirstName= By.xpath("//input[@name='firstName']");
   private By registlastName= By.xpath("//input[@name='lastName']");
   private By registerEmail= By.xpath("//input[@name='email']");
   private By registPhone= By.xpath("//input[@name='phone']");
   private By registPassword= By.xpath("//input[@name='password']");
   private By registrePassword= By.xpath("//input[@name='confirmPassword']");
   private By registAdress= By.xpath("//input[@name='address']");
   private By registCity= By.xpath("//input[@name='city']");
   private By registState= By.xpath("//input[@name='state']");
   private By registZip= By.xpath("//input[@name='zip']");
   private By clickCreate= By.id("createAccount");


    public RegistrationPage(WebDriver driver)
    {
       this.driver=driver;
    }

    public void clickOnRegister(){

        driver.findElement(registerbutton).click();
    }

    public void typeFirstName(String firstName){
        driver.findElement(registfirstName).sendKeys(firstName);

    }
    public void typeLastName(String lastName) {

        driver.findElement(registlastName).sendKeys(lastName);
    }
    public void typeEmail(String email){

        driver.findElement(registerEmail).sendKeys(email);
    }

    public void typePhone(String phone){

        driver.findElement(registPhone).sendKeys(phone);
    }
    public void typePassword(String password){

        driver.findElement(registPassword).sendKeys(password);
    }
    public void typeRePassword(String confirmPassword){

        driver.findElement(registrePassword).sendKeys(confirmPassword);
    }
    public void typeAdress(String address){

        driver.findElement(registAdress).sendKeys(address);
    }

    public void typeCity(String city){

        driver.findElement(registCity).sendKeys(city);
    }

    public void typeState(String state){

        driver.findElement(registState).sendKeys(state);
    }

    public void typeZip(String zip){

        driver.findElement(registZip).sendKeys(zip);
    }

    public void clickCreate(){

        driver.findElement(clickCreate).click();
    }



//
//    }
//    public void clickOnLoginButton(){
//        driver.findElement(loginButton).click();




//    public String getLoginTitle() {
//        return driver.findElement(titleText).getText();
//    }
}

