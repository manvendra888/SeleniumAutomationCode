import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
public class WindowsActivities {
    public static void main(String args[]){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        driver.navigate().to("https://newersworld.tothenew.com/#/home");
        driver.navigate().back();
        driver.navigate().forward();
    }
}
