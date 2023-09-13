import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsHandle {
    public static void main(String args[]) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        String parent = driver.getWindowHandle();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> ls = driver.getWindowHandles();
        String email_ID = null;
        Iterator<String> i = ls.iterator();
        while(i.hasNext()) {
            String child = i.next();
            if(!parent.equals(child)) {
                driver.switchTo().window(child);
                Thread.sleep(2000);
                System.out.println(driver.getCurrentUrl());
                System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
                driver.findElement(By.cssSelector(".im-para.red")).getText();
                 email_ID = driver.findElement(By.cssSelector(".im-para.red")).getText().
                        split("at")[1].trim().split(" ")[0];
                System.out.println(email_ID);

                driver.close();
            }
        }

            driver.switchTo().window(parent);
            System.out.println(email_ID);
            driver.findElement(By.id("username")).sendKeys(email_ID);
            Thread.sleep(1000);
            driver.close();
    }

}
