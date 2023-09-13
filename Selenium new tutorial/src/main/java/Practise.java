import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class Practise {
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.println("its disabled");
            Assert.assertTrue(true);
        }
        else{
            // System.out.println("its disabled");
            Assert.assertFalse(false);
        }
        driver.findElement(By.name("ctl00$mainContent$chk_SeniorCitizenDiscount")).click();
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
        driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
    }
}
