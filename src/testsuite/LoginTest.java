package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following step into 'LoginTest' class
 * 1.userShouldNavigateToLoginPageSuccessfully
 *   click on the 'sign in' link
 *   Verify the text 'Welcome Back!'
 * 2. verifyTheErrorMessage
 *  click on the 'Sign In' link
 *  Enter invalid username
 *  Enter invalid password
 *  Click on the login button
 *  Verify the error message 'Invalid email or password'
 */

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){

        openBrowser(baseUrl);//Calling method BaseTest class to open and set-up the browser
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        // Click on the 'Sign In' link and find element
        driver.findElement(By.linkText("Sign In")).click();
        String actualText = driver.findElement(By.xpath("//h2[@class = 'page__heading']")).getText();
        String expectedText = "Welcome Back!";
        Assert.assertEquals(expectedText,actualText);//Verify actual and expected text
    }

    @Test
    public void verifyTheErrorMessage(){
        userShouldNavigateToLoginPageSuccessfully();//redirect to the sign-in page
        driver.findElement(By.name("user[email]")).sendKeys("HARRY");
        driver.findElement(By.name("user[password")).sendKeys("1234");
        driver.findElement(By.xpath("//button[@type = 'submit'])")).click();//find the element and submit and click
        //Find the element for the error message and store the error message
        String actualError = driver.findElement(By.xpath("//li[@class = 'form-error__list-item']")).getText();
        String expectedError = "Invalid email or password."; //expected error message
        Assert.assertEquals(expectedError,actualError); // verify expected and actual text
    }

    @After
    public void tearDown(){
        closeBrowser();//calling method from BaseTest class to close browser

    }

}
