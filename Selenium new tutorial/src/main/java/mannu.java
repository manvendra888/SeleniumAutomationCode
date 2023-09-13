import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class mannu {
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        // Chrome Browser

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rahulshettyacademy.com/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
       // driver.close();
        //	driver.quit();
    }
}
