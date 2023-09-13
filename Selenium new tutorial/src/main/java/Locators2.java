import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class Locators2 {
    public static void main(String args[]) throws InterruptedException{
      //  String name="rahul";
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String password=getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.className("signInBtn")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello rahul,");
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        driver.close();
    }
    public static   String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
       String PasswordText= driver.findElement(By.cssSelector("form p")).getText();
       //Please use temporary password 'rahulshettyacademy' to Login.
        String[] passwordArray=PasswordText.split("'");
   //     String[] passwordArray2= passwordArray[1].split("'");
      //  passwordArray2[0]
        String password= passwordArray[1].split("'")[0];
        return password;
    }

}
