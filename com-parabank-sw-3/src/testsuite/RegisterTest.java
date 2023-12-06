package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
//       * click on the ‘Register’ link
        WebElement register = driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a"));
        register.click();
//       * Verify the text ‘Signing up is easy!’
        String actualResult = driver.findElement(By.xpath("//div[@id='rightPanel']/h1")).getText();
        System.out.println(actualResult);
        String expectedResult = "Signing up is easy!";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
//       * click on the ‘Register’ link
        WebElement register = driver.findElement(By.xpath("//div[@id='loginPanel']/p[2]/a"));
        register.click();
//       * Enter First name
        WebElement firstName = driver.findElement(By.id("customer.firstName"));
        firstName.sendKeys("Khushpatel");
//       * Enter Last name
        WebElement lastName = driver.findElement(By.id("customer.lastName"));
        lastName.sendKeys("Patel");
//       * Enter Address
        WebElement address = driver.findElement(By.id("customer.address.street"));
        address.sendKeys("20 High ");
//       * Enter City
        WebElement city = driver.findElement(By.id("customer.address.city"));
        city.sendKeys("Dagenham");
//       * Enter State
        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.sendKeys("Essex");
//       * Enter Zip Code
        WebElement zipCode = driver.findElement(By.id("customer.address.zipCode"));
        zipCode.sendKeys("RM12 2JH");
//       * Enter Phone
        WebElement phone = driver.findElement(By.id("customer.phoneNumber"));
        phone.sendKeys("9879731846");
//       * Enter SSN
        driver.findElement(By.id("customer.ssn")).sendKeys("1245");
//       * Enter Username
        WebElement username = driver.findElement(By.id("customer.username"));
        username.sendKeys("Khushbu280821");
//       * Enter Password
        WebElement password = driver.findElement(By.id("customer.password"));
        password.sendKeys("Khushbu@2802#");
//       * Enter Confirm
        WebElement confirmPassword = driver.findElement(By.id("repeatedPassword"));
        confirmPassword.sendKeys("Khushbu@2802#");
//       * Click on REGISTER button
        WebElement registerButton = driver.findElement(By.xpath("//form[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"));
        registerButton.click();
//       * Verify the text 'Your account was created successfully. You are now logged in.’
        Thread.sleep(1000);
        String actualText1 = driver.findElement(By.xpath("//div[@id=\"rightPanel\"]/p")).getText();
        System.out.println(actualText1);
        String expectedText1 = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals(actualText1, expectedText1);
    }
    @After
    public void endTest(){
        closeBrowser();
    }
}
