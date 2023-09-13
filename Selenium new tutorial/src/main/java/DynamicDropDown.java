import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DynamicDropDown {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());

        //  ..........Handling the check box
       // System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
        driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
        System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());


        // To check that the  button is enabled or diabled
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
            System.out.println("its enabled");
             Assert.assertTrue(true);
        }
        else{
           // System.out.println("its disabled");
            Assert.assertFalse(false);
        }


        //Count the numbers of check boxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000L);
       int i=1;
        while(i<5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;

        }

           driver.findElement(By.id("btnclosepaxoption")).click();
           Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
           System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }
}
